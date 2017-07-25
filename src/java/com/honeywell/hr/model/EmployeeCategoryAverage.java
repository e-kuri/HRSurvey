/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author H255735
 */
@Entity
@Table(name = "EmployeeCategoryAverage")
public class EmployeeCategoryAverage {
    
    @EmbeddedId
    EmployeeCategoryAveragePK id;
    
    @MapsId("idCatGrade")
    @ManyToOne
    @JoinColumn(name = "idCatGrade")
    private CatGrade catGrade;
    
    @MapsId("idEmployee")
    @ManyToOne
    @JoinColumn(name = "idEmployee")
    private Employee employee;
   
    @Column(name = "average")
    private Float average;
    
    @Column(name = "updated", updatable = false, insertable = false)
    private Date updated;

    public EmployeeCategoryAveragePK getId() {
        return id;
    }

    public void setId(EmployeeCategoryAveragePK id) {
        this.id = id;
    }

    public CatGrade getCatGrade() {
        return catGrade;
    }

    public void setCatGrade(CatGrade catGrade) {
        this.catGrade = catGrade;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }

    public Date getUpdated() {
        return updated;
    }
    
}
