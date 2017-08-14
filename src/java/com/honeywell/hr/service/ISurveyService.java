/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service;

import com.honeywell.hr.exception.ClosedSurveyException;
import com.honeywell.hr.model.CatGrade;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.Grade;
import com.honeywell.hr.model.Survey;
import java.util.List;

/**
 *
 * @author H255735
 */
public interface ISurveyService {
    
    Survey createAndSaveSurvey(Employee evaluator, Employee evaluated);
    List<Survey> getSurveysForEmployee(String employeeId);
    Survey getSurveyById(int surveyId);
    void answerSurvey(int gradeId, short grade)throws ClosedSurveyException;
    Grade getSingleGradeToUpdate();
    
}
