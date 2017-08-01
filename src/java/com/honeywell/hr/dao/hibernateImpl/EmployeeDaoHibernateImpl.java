/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.dao.hibernateImpl;

import com.honeywell.hr.dao.EmployeeDao;
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
public class EmployeeDaoHibernateImpl implements EmployeeDao{

    @Autowired
    private SessionFactory sessionFactory;

    
    @Override
    public void create(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        Survey survey = new Survey();
        Employee emp = new Employee();
        emp.setId(1);
        survey.setEvaluator(employee);
        survey.setEvaluated(employee);
        survey.setAnswered(false);
    }

    @Override
    public Employee getEmployeeByEmployeeNumber(String employeeNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
