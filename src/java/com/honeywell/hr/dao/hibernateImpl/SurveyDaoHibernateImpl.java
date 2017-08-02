/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.dao.hibernateImpl;

import com.honeywell.hr.dao.SurveyDao;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.Survey;
import com.honeywell.hr.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        session.beginTransaction();
        Integer id = (Integer)session.save(survey);
        session.getTransaction().commit();
        return id;
    }

    @Override
    public void update(Survey survey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
