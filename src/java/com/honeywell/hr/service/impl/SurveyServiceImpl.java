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
public class SurveyServiceImpl implements ISurveyService, InitializingBean{
    
    @Autowired
    private SurveyDao surveyDao;
    
    @Autowired
    private CatGradeDao catGradeDao;
    
    private List<CatGrade> gradeCategories;
    
    @Override
    public Integer createAndSave(Employee evaluator, Employee evaluated) {
        Survey survey = new Survey(evaluated, evaluator);
        survey.setId(surveyDao.save(survey));
        List<Grade> grades = new ArrayList<>(gradeCategories.size());
        for(CatGrade cat : gradeCategories){
            Grade grade = new Grade(survey, cat);
            grades.add(grade);
        }
        survey.setGrades(grades);
        return surveyDao.save(survey);
    }
    /*
    public void sendMail(){
        
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("eugenio.kuri@gmail.com");
        msg.setFrom("honeywell.tester69@gmail.com");
        msg.setSubject("test");
        msg.setText("my test");
        try{
            this.mailSender.send(msg);
        }catch(MailException e){
            System.out.println(e);
        }
    }
*/

    @Override
    public List<Survey> getSurveysForEmployee(String employeeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void refreshCategoriesList(){
        this.gradeCategories = getGradeCategories();
    }
    
    private List<CatGrade> getGradeCategories(){
        return catGradeDao.getAllCategories();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        refreshCategoriesList();
    }
    
}
