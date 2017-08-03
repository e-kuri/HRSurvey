/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service.impl;

import com.honeywell.hr.dao.CatGradeDao;
import com.honeywell.hr.dao.SurveyDao;
import com.honeywell.hr.model.CatGrade;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.Grade;
import com.honeywell.hr.model.Survey;
import com.honeywell.hr.service.ICatGradeService;
import com.honeywell.hr.service.ISurveyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author H255735
 */
@Service
public class SurveyServiceImpl implements ISurveyService{
    
    @Autowired
    private SurveyDao surveyDao;
    
    @Autowired
    private CatGradeDao catGradeDao;
    
    @Autowired
    private ICatGradeService catGradeService;
    
    @Override
    public Integer createAndSaveSurvey(Employee evaluator, Employee evaluated) {
        Survey survey = new Survey(evaluated, evaluator);
        survey.setId(surveyDao.save(survey));
        List<CatGrade> categories = catGradeService.getInMemoryCategories();
        List<Grade> grades = new ArrayList<>(categories.size());
        for(CatGrade cat : categories){
            Grade grade = new Grade(survey, cat);
            grades.add(grade);
        }
        survey.setGrades(grades);
        return surveyDao.save(survey);
    }

    @Override
    public List<Survey> getSurveysForEmployee(String employeeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Survey getSurveyById(int surveyId) {
        return surveyDao.getSurveyById(surveyId);
    }
    
}
