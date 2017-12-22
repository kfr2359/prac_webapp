package DAO;

import DAO.EmployeeDAO;
import DAO.GenericDAOImpl;
import logic.Employee;
import logic.Job;
import logic.Service;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Query;

public class EmployeeDAOImpl extends GenericDAOImpl<Employee> implements EmployeeDAO {    
    public EmployeeDAOImpl() {
        super(Employee.class);
    }

    public Collection<Employee> getByJob(Job job) {
        Session session = null;
        List<Employee> cce = new ArrayList<Employee>();
        try {
            int j_id = job.getId();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee where job.id=:job_id").setInteger("job_id", j_id);
            cce = (List<Employee>) query.list();
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
    
    public Collection<Employee> getByService(Service service) {
        Session session = null;
        List<Employee> cce = new ArrayList<Employee>();
        try {
            int s_id = service.getId();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery(
                "select e from Employee e inner join e.serviceEmployee se "
                                       + "inner join se.service s where s.id=:service_id").setInteger("service_id", s_id);
            cce = (List<Employee>) query.list();
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
