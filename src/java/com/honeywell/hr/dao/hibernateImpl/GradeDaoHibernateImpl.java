/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.honeywell.hr.dao.hibernateImpl;

import com.honeywell.hr.dao.GradeDao;
import com.honeywell.hr.model.Grade;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author H255735
 */
@Repository
public class GradeDaoHibernateImpl implements GradeDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Grade getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Grade grade = (Grade)session.get(Grade.class, id);
        return grade;
    }

    @Override
    public void update(Grade grade) {
        Session session = sessionFactory.getCurrentSession();
        session.update(grade);
    }
    
}
