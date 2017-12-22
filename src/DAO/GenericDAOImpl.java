package DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import util.HibernateUtil;

public abstract class GenericDAOImpl<T extends Serializable> implements GenericDAO<T> {
    Class<T> classType;
    
    public GenericDAOImpl(Class<T> aclassType) {
        this.classType = aclassType;
    }
    
    public void add(T obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    
    public void update(T obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete(T obj) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
    }
    
    public T getById(int id) {
        Session session = null;
        T dest = null;
        try {
            dest = classType.newInstance();
            session = HibernateUtil.getSessionFactory().openSession();
            session.load(dest, id);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return dest;
    }
    
    public Collection<T> getAll() {
        Session session = null;
        List<T> objs = new ArrayList<T>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            objs = session.createCriteria(classType).list();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return objs;
    }
    
}
