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
import org.springframework.stereotype.Repository;

/**
 *
 * @author H255735
 */
@Repository
public class SurveyDaoHibernateImpl implements SurveyDao{

    @Override
    public List<Survey> surveysByEmployee(String employeeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Employee evaluated, Employee evaluator) {
        Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Survey survey = new Survey();
            Employee emp = new Employee();
            emp.setId(1);
            survey.setEvaluator(emp);
            survey.setEvaluated(emp);
            survey.setAnswered(false);
            session.save(survey);
            session.getTransaction().commit();
            HibernateUtil.shutdown();
    }

    @Override
    public void update(Survey survey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
