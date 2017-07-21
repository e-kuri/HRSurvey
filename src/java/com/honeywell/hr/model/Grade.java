/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.model;

/**
 *
 * @author H255735
 */
public class Grade {
    
    private final int id;
    private final String concept;
    private int grade;

    public Grade(String concept, int id){
        this.concept = concept;
        this.id = id;
    }
    
    public String getConcept() {
        return concept;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if(grade > 0 && grade < 6){
            this.grade = grade;
        }
    }
    
}
