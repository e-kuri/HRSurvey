/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.dao.impl;

import com.honeywell.hr.dao.EmployeeDao;
import com.honeywell.hr.model.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author H255735
 */
public class EmployeeDaoInMemoryImpl implements EmployeeDao{

    private static Map<String, Employee> employees;
    
    public EmployeeDaoInMemoryImpl(){
        employees = new HashMap<>();
        Employee kuri = new Employee("H255735");
        kuri.setEmail("Eugenio.Kuri@honeywell.com");
        kuri.setName("Eugenio Kuri Sainz");
        employees.put(kuri.getEmployeeNumber(), kuri);
        
        Employee hr = new Employee("H696969");
        hr.setEmail("honeywell.tester69@gmail.com");
        hr.setName("John Digweed");
        employees.put(hr.getEmployeeNumber(), hr);
    }
    
    @Override
    public void addEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getEmployeeByEmployeeNumber(String employeeNumber) {
        return employees.get(employeeNumber);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<Employee>(employees.values());
    }

    @Override
    public void updateEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
