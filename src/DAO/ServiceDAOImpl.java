package DAO;

import DAO.ServiceDAO;
import DAO.GenericDAOImpl;
import logic.Service;
import logic.ServiceType;
import logic.Client;
import logic.Employee;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Query;

public class ServiceDAOImpl extends GenericDAOImpl<Service> implements ServiceDAO {    
    public ServiceDAOImpl() {
        super(Service.class);
    }

    public Collection<Service> getByServiceType(ServiceType serviceType) {
        Session session = null;
        List<Service> cce = new ArrayList<Service>();
        try {
            int st_id = serviceType.getId();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Service where type.id=:type_id").setInteger("type_id", st_id);
            cce = (List<Service>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cce;
    }
    
    public Collection<Service> getByClient(Client client) {
        Session session = null;
        List<Service> cce = new ArrayList<Service>();
        try {
            int c_id = client.getId();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Service where client.id=:client_id").setInteger("client_id", c_id);
            cce = (List<Service>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cce;
    }
    
    public Collection<Service> getByEmployee(Employee employee) {
        Session session = null;
        List<Service> cce = new ArrayList<Service>();
        try {
            int e_id = employee.getId();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(
                "select s from Service s inner join s.serviceEmployee se "
                                      + "inner join se.employee e where e.id=:employee_id").setInteger("employee_id", e_id);
            cce = (List<Service>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cce;
    }
}
