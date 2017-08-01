/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.controller;

import com.honeywell.hr.delegate.ISurveyDelegate;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.Survey;
import com.honeywell.hr.service.IMailService;
import com.honeywell.hr.service.ISurveyService;
import com.honeywell.hr.service.impl.SurveyServiceImpl;
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
    
    @Autowired
    private ISurveyDelegate surveyDelegate;
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String init(){
        return "newMail";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String sendSurvey(Employee employee, @RequestParam String emailBody){
        surveyDelegate.createAndSend(employee, emailBody);
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
    
}
