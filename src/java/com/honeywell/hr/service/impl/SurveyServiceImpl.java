/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service.impl;

import com.honeywell.hr.dao.CatGradeDao;
import com.honeywell.hr.dao.GradeDao;
import com.honeywell.hr.dao.SurveyDao;
import com.honeywell.hr.exception.ClosedSurveyException;
import com.honeywell.hr.exception.InvalidValueException;
import com.honeywell.hr.model.CatGrade;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.Grade;
import com.honeywell.hr.model.Survey;
import com.honeywell.hr.service.ICatGradeService;
import com.honeywell.hr.service.ISurveyService;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author H255735
 */
@Service
public class SurveyServiceImpl implements ISurveyService{
    
    private static Logger logger = Logger.getLogger(SurveyServiceImpl.class);
    
    @Autowired
    private SurveyDao surveyDao;
    
    @Autowired
    private GradeDao gradeDao;
    
    @Autowired
    private ICatGradeService catGradeService;
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
//    @Transactional
    public Survey createAndSaveSurvey(Employee evaluator, Employee evaluated) {
        Survey survey = new Survey(evaluated, evaluator);
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        survey.setId(surveyDao.save(survey));
        List<CatGrade> categories = catGradeService.getInMemoryCategories();
        List<Grade> grades = new ArrayList<>(categories.size());
        for(CatGrade cat : categories){
            Grade grade = new Grade(survey, cat);
            grades.add(grade);
        }
        survey.setGrades(grades);
        Integer id = surveyDao.save(survey);
        session.getTransaction().commit();
        survey.setId(id);
        return survey;
    }

    @Override
    public List<Survey> getSurveysForEmployee(String employeeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
//    @Transactional
    public Survey getSurveyById(int surveyId) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            return surveyDao.getSurveyById(surveyId);
        }finally{
            session.getTransaction().commit();
        }
    }

    @Override
//    @Transactional
    public void answerSurvey(int gradeId, short rating) throws ClosedSurveyException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Grade grade = gradeDao.getById(gradeId);
        Survey survey = grade.getSurvey();
        if(survey.isAnswered()){
           throw new ClosedSurveyException();
       }
        try {
            grade.setGrade(rating);
            gradeDao.update(grade);
            survey = grade.getSurvey();
            survey.setAnswered(true);
            surveyDao.update(survey);
            session.getTransaction().commit();
        } catch (InvalidValueException ex) {
            logger.error(ex.getMessage() + " gradeId = " + gradeId);
            session.getTransaction().rollback();
        }
    }

    @Override
    public Grade getSingleGradeToUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
