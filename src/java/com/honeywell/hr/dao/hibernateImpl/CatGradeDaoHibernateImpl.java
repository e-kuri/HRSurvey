/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.dao.hibernateImpl;

import com.honeywell.hr.dao.CatGradeDao;
import com.honeywell.hr.model.CatGrade;
import com.honeywell.hr.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author H255735
 */
@Repository
public class CatGradeDaoHibernateImpl implements CatGradeDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<CatGrade> getAllCategories() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<CatGrade> categories = session.createCriteria(CatGrade.class).list();
        session.getTransaction().commit();
        return categories;
    }
    
}
