/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.service.impl;

import com.honeywell.hr.dao.CatGradeDao;
import com.honeywell.hr.model.CatGrade;
import com.honeywell.hr.service.ICatGradeService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author H255735
 */
@Service
@Transactional
public class CatGradeServiceImpl implements ICatGradeService, InitializingBean{

    private List<CatGrade> gradeCategories;
    
    @Autowired
    private CatGradeDao catGradeDao;
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<CatGrade> getAllCatGrades() {
        return catGradeDao.getAllCategories();
    }

    @Override
    public List<CatGrade> getInMemoryCategories() {
        return gradeCategories;
    }
    
    private void refreshCategoriesList(){
        this.gradeCategories = getAllCatGrades();
    }

    @Override
    public void afterPropertiesSet() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        refreshCategoriesList();
        session.getTransaction().commit();
    }
    
}
