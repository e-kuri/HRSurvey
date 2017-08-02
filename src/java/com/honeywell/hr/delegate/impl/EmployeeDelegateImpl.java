/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.delegate.impl;

import com.honeywell.hr.delegate.IEmployeeDelegate;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.service.IEmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author H255735
 */
@Component
public class EmployeeDelegateImpl implements IEmployeeDelegate{

    @Autowired
    private IEmployeeService employeeService;
    
    @Override
    public List<Employee> employeesForPartialEmployeeNumber(String partialEmpNum) {
        return employeeService.getEmployeesForPartialEmployeeNumber(partialEmpNum);
    }
    
}
