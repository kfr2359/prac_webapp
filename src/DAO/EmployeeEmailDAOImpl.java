package DAO;

import DAO.EmployeeEmailDAO;
import DAO.GenericDAOImpl;
import logic.EmployeeEmail;
import logic.Employee;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Query;

public class EmployeeEmailDAOImpl extends GenericDAOImpl<EmployeeEmail> implements EmployeeEmailDAO {    
    public EmployeeEmailDAOImpl() {
        super(EmployeeEmail.class);
    }

    public Collection<EmployeeEmail> getByEmployee(Employee employee) {
        Session session = null;
        List<EmployeeEmail> cce = new ArrayList<EmployeeEmail>();
        try {
            int e_id = employee.getId();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from EmployeeEmail where employee.id=:employee_id").setInteger("employee_id", e_id);
            cce = (List<EmployeeEmail>) query.list();
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
