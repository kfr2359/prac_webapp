package com.prac_webapp.DAO;

import com.prac_webapp.logic.EmployeePhone;
import com.prac_webapp.logic.Employee;
import com.prac_webapp.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;

public class EmployeePhoneDAOImpl extends GenericDAOImpl<EmployeePhone> implements EmployeePhoneDAO {    
    public EmployeePhoneDAOImpl() {
        super(EmployeePhone.class);
    }

    public Collection<EmployeePhone> getByEmployee(Employee employee) {
        Session session = null;
        List<EmployeePhone> cce = new ArrayList<EmployeePhone>();
        try {
            int e_id = employee.getId();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from EmployeePhone where employee.id=:employee_id").setInteger("employee_id", e_id);
            cce = (List<EmployeePhone>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return cce;
    }
}
