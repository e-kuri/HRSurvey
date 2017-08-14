/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service.impl;

import com.honeywell.hr.dao.GradeDao;
import com.honeywell.hr.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author H255735
 */
public class GradeServiceImpl implements IGradeService{
    
    @Autowired
    private GradeDao gradeDao;

    @Override
    public void setGrade(int idGrade, int grade) {
        
    }
  
}
