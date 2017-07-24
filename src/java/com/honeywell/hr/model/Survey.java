/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@Table(name = "Survey")
public class Survey {
    
    @Id
    @Column(name = "idSurvey")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee evaluator;
    
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee evaluated;
    
    @Column(name = "answered")
    private boolean answered;
    
    @Column(name = "comments")
    private String comments;
    
    @Column(name = "created", insertable = false, updatable = false)
    private Date created;
    
    @Column(name = "updated", insertable = false, updatable = false)
    private Date updated;

    public Employee getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(Employee evaluator) {
        this.evaluator = evaluator;
    }

    public Employee getEvaluated() {
        return evaluated;
    }

    public void setEvaluated(Employee evaluated) {
        this.evaluated = evaluated;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }
    
}
