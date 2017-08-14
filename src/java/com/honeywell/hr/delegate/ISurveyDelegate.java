/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.delegate;

import com.honeywell.hr.exception.ClosedSurveyException;
import com.honeywell.hr.model.CatGrade;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.Grade;
import com.honeywell.hr.model.Survey;
import java.util.List;
import java.util.Map;

/**
 *
 * @author H255735
 */
public interface ISurveyDelegate {
    
    void createAndSend(Employee employee, String subject, String body);
    Map<String, Object> getMapAttributesToShowSurvey(int surveyId, int rating);
    void answerSurvey(int gradeId, short grade) throws ClosedSurveyException;
    
}
