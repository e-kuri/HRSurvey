/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.delegate;

import com.honeywell.hr.model.Employee;
import java.util.List;

/**
 *
 * @author H255735
 */
public interface IEmployeeDelegate {
    List<Employee> employeesForPartialEmployeeNumber(String partialEmpNum);
}
