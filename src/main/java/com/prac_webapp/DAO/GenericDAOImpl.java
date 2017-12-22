package com.prac_webapp.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import com.prac_webapp.util.HibernateUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericDAOImpl<T extends Serializable> implements GenericDAO<T> {
    Class<T> classType;
    
    public GenericDAOImpl(Class<T> aclassType) {
        this.classType = aclassType;
    }
    
    public void add(T obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    
    public void update(T obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public void delete(T obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        
    }
    
    public T getById(int id) {
        Session session = null;
        T dest = null;
        try {
            dest = classType.newInstance();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.load(dest, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return dest;
    }
    
    public List<T> getAll() {
        Session session = null;
        List<T> objs = new ArrayList<T>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            objs = session.createCriteria(classType).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return objs;
    }
    
}
