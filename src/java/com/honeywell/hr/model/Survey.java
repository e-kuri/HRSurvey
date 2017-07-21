/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author H255735
 */
public class Survey {
    
    private final int id;
    private final Employee evaluator;
    private final Employee evaluated;
    private List<Grade> grades;
    private String comments;
    
    public Survey(int id, Employee evaluator, Employee evaluated){
        this.id = id;
        this.evaluated = evaluated;
        this.evaluator = evaluator;
    }

    public int getId() {
        return id;
    }

    public Employee getEvaluator() {
        return evaluator;
    }

    public Employee getEvaluated() {
        return evaluated;
    }
    
    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public void addGrade(Grade grade){
        if(this.grades == null){
            this.grades = new ArrayList<>();
        }
        this.grades.add(grade);
    }
    
}
