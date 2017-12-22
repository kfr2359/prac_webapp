package DAO;

import DAO.ServiceEmployeeDAO;
import DAO.GenericDAOImpl;
import logic.Service;
import logic.ServiceEmployee;
import logic.Employee;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Query;

public class ServiceEmployeeDAOImpl extends GenericDAOImpl<ServiceEmployee> implements ServiceEmployeeDAO {    
    public ServiceEmployeeDAOImpl() {
        super(ServiceEmployee.class);
    }

    public Collection<ServiceEmployee> getByService (Service service) {
        Session session = null;
        List<ServiceEmployee> cce = new ArrayList<ServiceEmployee>();
        try {
            int s_id = service.getId();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from ServiceEmployee where service.id=:service_id").setInteger("service_id", s_id);
            cce = (List<ServiceEmployee>) query.list();
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
    
    public Collection<ServiceEmployee> getByEmployee (Employee employee) {
        Session session = null;
        List<ServiceEmployee> cce = new ArrayList<ServiceEmployee>();
        try {
            int e_id = employee.getId();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from ServiceEmployee where employee.id=:employee_id").setInteger("employee_id", e_id);
            cce = (List<ServiceEmployee>) query.list();
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
