/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.Survey;
import com.honeywell.hr.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author H255735
 */
public class TestSurvey {
    
    private SessionFactory sessionFactory;
    
    @Before
    public void before(){
         Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addAnnotatedClass(Survey.class);
            configuration.addAnnotatedClass(Employee.class);
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    
    @Test
    public void testInsertSurvey(){
        try{
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
