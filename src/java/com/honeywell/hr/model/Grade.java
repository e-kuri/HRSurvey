/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.model;

import com.honeywell.hr.exception.InvalidValueException;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author H255735
 */
@Entity
@Table(name = "Grade")
public class Grade {

    public Grade(){}
    
    public Grade(Survey survey, CatGrade catGrade){
        this.survey = survey;
        this.catGrade = catGrade;
    }
    
    @Id
    @Column(name = "idGrade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "grade")
    private Short grade;
    
    @Column(name = "created", insertable = false, updatable = false)
    private Date created;
    
    @Column(name = "updated", insertable = false, updatable = false)
    private Date updated;
    
    @ManyToOne
    @JoinColumn(name = "idCatGrade")
    private CatGrade catGrade;
    
    @ManyToOne
    @JoinColumn(name = "idSurvey")
    private Survey survey;

    public Short getGrade() {
        return grade;
    }

    public void setGrade(short grade) throws InvalidValueException {
        if(grade > 0 && grade < 6){
            this.grade = grade;
        }else{
            throw new InvalidValueException("Grade must be between 1 and 5");
        }
    }

    public CatGrade getCatGrade() {
        return catGrade;
    }

    public void setCatGrade(CatGrade catGrade) {
        this.catGrade = catGrade;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }
    
}
