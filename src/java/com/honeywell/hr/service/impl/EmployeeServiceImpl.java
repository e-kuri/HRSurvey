/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service.impl;

import com.honeywell.hr.dao.EmployeeDao;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.service.IEmployeeService;
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author H255735
 */
@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService{
    
    @Autowired
    private EmployeeDao employeeDao;
    
    public List<Employee> getEmployeesForPartialEmployeeNumber(String partialEmpNum){
        return employeeDao.getEmployeesForPartialEmployeeNumber(partialEmpNum);
    }
    
    public File generateEmployeeSignature(int employeeId){
        Employee employee = employeeDao.getEmployeeById(employeeId);
        
        return null;
    }
    
}
