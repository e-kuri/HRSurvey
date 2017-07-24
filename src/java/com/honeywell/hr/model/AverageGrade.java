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
public class AverageGrade {
    
    private Employee employee;
    //private Grade.GradeCategory category;
    private int average;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }
    
}
