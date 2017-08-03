/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.dao;

import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.Survey;
import java.util.List;

/**
 *
 * @author H255735
 */
public interface SurveyDao {
    
    List<Survey> surveysByEmployee(String employeeId);
    Integer save(Survey survey);
    void update(Survey survey);
    Survey getSurveyById(int surveyId);
    
}
