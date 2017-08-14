/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.dao.hibernateImpl;

import com.honeywell.hr.dao.SurveyDao;
import com.honeywell.hr.model.Survey;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author H255735
 */
@Repository
public class SurveyDaoHibernateImpl implements SurveyDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Survey> surveysByEmployee(String employeeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer save(Survey survey) {
        Session session = sessionFactory.getCurrentSession();
        Integer id = (Integer)session.save(survey);
        return id;
    }

    @Override
    public void update(Survey survey) {
        Session session = sessionFactory.getCurrentSession();
        session.update(survey); 
   }

    @Override
    public Survey getSurveyById(int surveyId) {
        Session session = sessionFactory.getCurrentSession();
        Survey survey = (Survey)session.get(Survey.class, surveyId);
        return survey;
    }
    
}
