/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.dao.hibernateImpl;

import com.honeywell.hr.dao.EmployeeDao;
import com.honeywell.hr.model.Employee;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author H255735
 */
@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao{

    @Override
    public void create(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
