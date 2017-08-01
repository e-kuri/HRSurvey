/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.dao.memoryimpl;

import com.honeywell.hr.dao.SurveyDao;
import com.honeywell.hr.model.Employee;
import com.honeywell.hr.model.Grade;
import com.honeywell.hr.model.Survey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author H255735
 */
public class SurveyDaoInMemoryImpl implements SurveyDao{

    private static Map<Integer, Survey> surveys;
    
    static{
        surveys = new LinkedHashMap<>();
    }
    
    @Override
    public List<Survey> surveysByEmployee(String employeeNumber) {
        List<Survey> result = new LinkedList<>();
        Iterator it = surveys.values().iterator();
        while(it.hasNext()){
            Survey survey = (Survey)it.next();
            if(survey.getEvaluated().getEmployeeNumber().equalsIgnoreCase(employeeNumber)){
                result.add(survey);
            }
        }
        return result;
    }

    public void create(Employee evaluated, Employee evaluator) {
        int id = 0;
        Iterator it = surveys.entrySet().iterator();
        while(it.hasNext()){
            id = ((Survey)((Map.Entry)it.next()).getValue()).getId();
        }
    }

    @Override
    public void update(Survey survey) {
       
    }

    @Override
    public Integer save(Survey survey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
