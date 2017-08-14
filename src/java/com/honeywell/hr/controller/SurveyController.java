/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.controller;

import com.honeywell.hr.delegate.ISurveyDelegate;
import com.honeywell.hr.exception.ClosedSurveyException;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.Grade;
import com.honeywell.hr.model.Survey;
import com.honeywell.hr.service.IMailService;
import com.honeywell.hr.service.ISurveyService;
import com.honeywell.hr.service.impl.SurveyServiceImpl;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author H255735
 */
@Controller
@RequestMapping("/survey")
public class SurveyController {
    
    private static Logger logger = Logger.getLogger(SurveyController.class);
    
    @Autowired
    private ISurveyDelegate surveyDelegate;
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String init(){
        return "newMail";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String sendSurvey(Employee employee, @RequestParam(required = false) String subject,
            @RequestParam(required = false) String body){
        surveyDelegate.createAndSend(employee, subject, body);
        return "mailSent";
    }
    
    @RequestMapping("/save")
    public void create(){
        //mailService.sendMail();
        //surveyService.create(null, null);
    }
    
    @RequestMapping(value = "/surveysByEmployee", method = RequestMethod.GET)
    public String getSurveysByEmployer(@RequestParam("employeeId") String employeeId, ModelMap model){
        
        return "employeeDetails";
    }
    
    @RequestMapping(value = "/answer", method = RequestMethod.GET)
    public String answerSurvey(@RequestParam int idGrade, @RequestParam short grade){
        try {
            surveyDelegate.answerSurvey(idGrade, grade);
        } catch (ClosedSurveyException ex) {
            logger.info(ex + " idGrade: " + idGrade);
            return "alreadyAnsweredSurvey";
        }
        return "answeredSurvey";
    }
    
    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public String saveSurvey(@RequestParam("idSurvey") int surveyId,
            @RequestParam("rating") int rating){
        return "newMail";
    }
    
}
