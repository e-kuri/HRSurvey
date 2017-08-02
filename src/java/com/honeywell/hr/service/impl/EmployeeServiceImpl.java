/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service.impl;

import com.honeywell.hr.dao.EmployeeDao;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.service.IEmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author H255735
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService{
    
    @Autowired
    private EmployeeDao employeeDao;
    
    public List<Employee> getEmployeesForPartialEmployeeNumber(String partialEmpNum){
        return employeeDao.getEmployeesForPartialEmployeeNumber(partialEmpNum);
    }
    
}
