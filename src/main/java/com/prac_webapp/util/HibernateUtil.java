package com.prac_webapp.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class HibernateUtil {
    @Autowired
    private static SessionFactory sessionFactory;
    /*
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        if (sessionFactory.isClosed()) {
            sessionFactory.openSession();
        }
        return sessionFactory;
    }
}