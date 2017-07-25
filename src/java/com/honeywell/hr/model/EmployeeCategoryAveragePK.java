/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author H255735
 */
@Embeddable
public class EmployeeCategoryAveragePK implements Serializable{
    
    private Integer idCatGrade;
    private Integer idEmployee;

    public Integer getIdCatGrade() {
        return idCatGrade;
    }

    public void setIdCatGrade(int idCatGrade) {
        this.idCatGrade = idCatGrade;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
    
}
