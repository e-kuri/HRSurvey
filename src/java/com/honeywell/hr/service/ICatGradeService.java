/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service;

import com.honeywell.hr.model.CatGrade;
import java.util.List;

/**
 *
 * @author H255735
 */
public interface ICatGradeService {
    
    List<CatGrade> getAllCatGrades();
    List<CatGrade> getInMemoryCategories();
    
}
