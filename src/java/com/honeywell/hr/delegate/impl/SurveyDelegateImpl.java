/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.delegate.impl;

import com.honeywell.hr.model.Employee;
import org.springframework.stereotype.Component;
import com.honeywell.hr.delegate.ISurveyDelegate;
import com.honeywell.hr.model.Survey;
import com.honeywell.hr.service.IMailService;
import com.honeywell.hr.service.ISurveyService;
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
    
    @Override
    public void createAndSend(Employee employee, String mailBody) {
        Integer surveyId = surveyService.createAndSave(employee, employee);
        mailService.createAndSendEmail(employee, mailBody, surveyId);
    }
    
}
