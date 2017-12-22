package com.prac_webapp.DAO;

import com.prac_webapp.logic.Service;
import com.prac_webapp.logic.ServiceType;
import com.prac_webapp.logic.Client;
import com.prac_webapp.logic.Employee;
import com.prac_webapp.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public class ServiceDAOImpl extends GenericDAOImpl<Service> implements ServiceDAO {    
    public ServiceDAOImpl() {
        super(Service.class);
    }

    public Collection<Service> getByServiceType(ServiceType serviceType) {
        Session session = null;
        List<Service> cce = new ArrayList<Service>();
        try {
            int st_id = serviceType.getId();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Service where type.id=:type_id").setInteger("type_id", st_id);
            cce = (List<Service>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return cce;
    }
    
    public Collection<Service> getByClient(Client client) {
        Session session = null;
        List<Service> cce = new ArrayList<Service>();
        try {
            int c_id = client.getId();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Service where client.id=:client_id").setInteger("client_id", c_id);
            cce = (List<Service>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return cce;
    }
    
    public Collection<Service> getByEmployee(Employee employee) {
        Session session = null;
        List<Service> cce = new ArrayList<Service>();
        try {
            int e_id = employee.getId();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery(
                "select s from Employee e join e.services s where e.id=:employee_id").setInteger("employee_id", e_id);
            cce = (List<Service>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return cce;
    }
}
