/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.dao;

import com.honeywell.hr.model.Employee;
import java.util.List;

/**
 *
 * @author H255735
 */
public interface EmployeeDao {
    public void create(Employee employee);
    public Employee getEmployeeByEmployeeNumber(String employeeNumber);
    public List<Employee> getAll();
    public void update(Employee employee);
    public List<Employee> getEmployeesForPartialEmployeeNumber(String partialEmployeeNumber);
}
