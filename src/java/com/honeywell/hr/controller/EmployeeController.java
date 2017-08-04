/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.honeywell.hr.delegate.IEmployeeDelegate;
import com.honeywell.hr.model.CatGrade;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.TestObject;
import com.honeywell.hr.service.IEmployeeService;
import java.util.LinkedList;
import java.util.List;
import javax.swing.text.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author H255735
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private IEmployeeDelegate employeeDelegate;
    
    @RequestMapping("/list")
    public String getEmployeesWithAverageGrades(ModelMap model){
        model.addAttribute("employees", model);
        return "listEmployers";
    }
    
}
