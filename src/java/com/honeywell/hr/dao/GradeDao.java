/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.dao;

import com.honeywell.hr.model.Grade;

/**
 *
 * @author H255735
 */
public interface GradeDao {
    
    Grade getById(int id);
    void update(Grade grade);
    
}
