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
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author H255735
 */
@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao{

    private static Logger logger = Logger.getLogger(EmployeeDao.class);
    
    @Autowired
    private SessionFactory sessionFactory;

    
    @Override
    public void create(Employee employee) {
        
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

    @Override
    public List<Employee> getEmployeesForPartialEmployeeNumber(String partialEmployeeNumber) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);
        List<Employee> employees = null;
        try{
            employees = criteria.add(Restrictions.like("employeeNumber", partialEmployeeNumber, MatchMode.START)).list();
        }catch(HibernateException e){
            logger.error(e.getCause());
        }
        
        return employees;
    }
    
}
