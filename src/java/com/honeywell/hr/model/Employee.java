/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author H255735
 */
@Entity
@Table(name = "Employee")
public class Employee {
    
    @Id
    @Column(name = "idEmployee")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "employeeNumber", unique = true)
    private String employeeNumber;
    
    @Column(name = "firstName")
    private String firstName;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "isHR")
    private Boolean isHR;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "created", insertable = false, updatable = false)
    private Date created;
    
    @Column(name = "updated", insertable = false, updatable = false)
    private Date updated;

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getIsHR() {
        return isHR;
    }

    public void setIsHR(Boolean isHR) {
        this.isHR = isHR;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
