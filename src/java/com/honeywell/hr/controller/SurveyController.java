/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.controller;

import com.honeywell.hr.model.Survey;
import com.honeywell.hr.service.impl.SurveyService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author H255735
 */
@Controller
@RequestMapping("/survey")
public class SurveyController {
    
    @Autowired
    private SurveyService surveyService;
    
    @RequestMapping("/new")
    public String init(HttpServletRequest request, HttpServletResponse response){
       //ModelAndView mv = new ModelAndView("newSurvey");
        return "newSurvey";
    }
    
    @RequestMapping("/create")
    public void create(){
        surveyService.sendMail();
    }
    
}
