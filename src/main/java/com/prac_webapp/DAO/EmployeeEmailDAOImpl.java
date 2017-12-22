package com.prac_webapp.DAO;

import com.prac_webapp.logic.EmployeeEmail;
import com.prac_webapp.logic.Employee;
import com.prac_webapp.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from EmployeeEmail where employee.id=:employee_id").setInteger("employee_id", e_id);
            cce = (List<EmployeeEmail>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return cce;
    }
}
