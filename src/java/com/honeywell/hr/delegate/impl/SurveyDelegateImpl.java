/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.delegate.impl;

import com.honeywell.hr.model.Employee;
import org.springframework.stereotype.Component;
import com.honeywell.hr.delegate.ISurveyDelegate;
import com.honeywell.hr.model.CatGrade;
import com.honeywell.hr.model.Survey;
import com.honeywell.hr.service.ICatGradeService;
import com.honeywell.hr.service.IMailService;
import com.honeywell.hr.service.ISurveyService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author H255735
 */
@Component
public class SurveyDelegateImpl implements ISurveyDelegate{

    @Autowired
    private ISurveyService surveyService;
    
    @Autowired
    private IMailService mailService;
    
    @Autowired
    private ICatGradeService catGradeService;
    
    @Override
    public void createAndSend(Employee employee) {
        employee.setId(1);
        Integer surveyId = surveyService.createAndSaveSurvey(employee, employee);
        mailService.createAndSendEmail(employee, surveyId);
    }

    @Override
    public Map<String, Object> getMapAttributesToShowSurvey(int surveyId, int rating) {
        Map<String, Object> model = new HashMap<>();
        model.put("survey", surveyService.getSurveyById(surveyId));
        model.put("rating", rating);
        return model;
    }
    
}
