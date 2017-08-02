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
import org.apache.log4j.Logger;
import org.hibernate.Query;
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
    
    private static final Logger logger = Logger.getLogger(CatGradeDaoHibernateImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<CatGrade> getAllCategories() {
        logger.debug("getting list of categories");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<CatGrade> categories = session.createCriteria(CatGrade.class).list();
        session.getTransaction().commit();
        logger.info("got " + categories.size() + " categories from the database");
        return categories;
    }
    
}
