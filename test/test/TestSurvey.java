/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.honeywell.hr.model.CatGrade;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.Survey;
import com.honeywell.hr.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Ignore;
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
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    
    @Test
    @Ignore
    public void testInsertSurvey(){
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Survey survey = new Survey();
            Employee emp = new Employee();
            emp.setId(1);
            survey.setEvaluator(emp);
            survey.setEvaluated(emp);
            survey.setAnswered(false);
            session.save(survey);
            session.getTransaction().commit();
            sessionFactory.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test
    public void testGetCategories(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<CatGrade> categories = session.createCriteria(CatGrade.class).list();
        session.getTransaction().commit();
        System.out.println("////// categories: " + categories.size());
    }
    
}
