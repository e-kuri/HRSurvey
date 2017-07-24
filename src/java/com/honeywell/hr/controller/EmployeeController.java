/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.controller;

import com.honeywell.hr.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author H255735
 */
@Controller
@RequestMapping("/employer")
public class EmployeeController {
    
    @Autowired
    private IEmployeeService employeeService;
    
    @RequestMapping("/list")
    public String getEmployeesWithAverageGrades(ModelMap model){
        model.addAttribute("employees", model);
        return "listEmployers";
    }
    
}
