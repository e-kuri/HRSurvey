/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.controller;

import com.honeywell.hr.model.TestObject;
import java.util.LinkedList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author H255735
 */
@RestController
public class EmployeeRestController {
    
    @RequestMapping(value = "/emplist/{partialId}", method = RequestMethod.GET)
    public List<TestObject> getIdsLike(@PathVariable String partialId){
        List<TestObject> employees = new LinkedList<>();
        TestObject g = new TestObject();
        employees.add(g);
        return employees;
    }
    
}
