/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.dao.memoryimpl;

import com.honeywell.hr.dao.EmployeeDao;
import com.honeywell.hr.model.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author H255735
 */
public class EmployeeDaoInMemoryImpl{

    private static Map<String, Employee> employees;
    
    static{
        employees = new HashMap<>();
        /*
        Employee kuri = new Employee("H255735");
        kuri.setEmail("Eugenio.Kuri@honeywell.com");
        kuri.setName("Eugenio Kuri Sainz");
        employees.put(kuri.getEmployeeNumber(), kuri);
        
        Employee hr = new Employee("H696969");
        hr.setEmail("honeywell.tester69@gmail.com");
        hr.setName("John Digweed");
        employees.put(hr.getEmployeeNumber(), hr);
*/
    }
    
    public void create(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Employee getEmployeeByEmployeeNumber(String employeeNumber) {
        return employees.get(employeeNumber);
    }

    public List<Employee> getAll() {
        return new ArrayList<Employee>(employees.values());
    }

    public void update(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
