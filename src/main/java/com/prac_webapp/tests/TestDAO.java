package com.prac_webapp.tests;

import java.util.Collection;

import org.hibernate.Session;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.prac_webapp.DAO.*;
import com.prac_webapp.logic.*;
import com.prac_webapp.util.HibernateUtil;

public class TestDAO extends Assert {
    @Test
    public void testClientContact() {
        ClientContactDAO cc_dao = DAOFactory.getClientContactDAO();
        ClientDAO        c_dao  = DAOFactory.getClientDAO();
          
        Client c1 = c_dao.getById(1);
        Collection<ClientContact> col_cc = cc_dao.getByClient(c1);
        assertEquals(col_cc.size(), 1);
        assertEquals(col_cc.iterator().next().getName().equals("Иванов Иван Иванович"), true);
    }
    
    @Test
    public void testClientContactEmail() {
        ClientContactDAO cc_dao = DAOFactory.getClientContactDAO();
        ClientContactEmailDAO cce_dao = DAOFactory.getClientContactEmailDAO();
        
        ClientContact cc1 = cc_dao.getById(1);
        Collection<ClientContactEmail> col_cce = cce_dao.getByClientContact(cc1);
        assertEquals(col_cce.size(), 1);
        assertEquals(col_cce.iterator().next().getEmail().equals("y.yvanov@mail.ru"), true);
    }

    @Test
    public void testClientContactPhone() {
        ClientContactDAO cc_dao = DAOFactory.getClientContactDAO();
        ClientContactPhoneDAO cce_dao = DAOFactory.getClientContactPhoneDAO();
        
        ClientContact cc1 = cc_dao.getById(1);
        Collection<ClientContactPhone> col_cce = cce_dao.getByClientContact(cc1);
        assertEquals(col_cce.size(), 1);
        assertEquals(col_cce.iterator().next().getPhone().equals("9092543321"), true);
    }

    @Test
    public void testEmployee1() {
        EmployeeDAO e_dao = DAOFactory.getEmployeeDAO();
        JobDAO j_dao = DAOFactory.getJobDAO();
        
        Job j1 = j_dao.getById(1);
        Collection<Employee> col_e = e_dao.getByJob(j1);
        assertEquals(col_e.size(), 1);
        assertEquals(col_e.iterator().next().getName().equals("Петров Андрей Алексеевич"), true);
    }   

    @Test
    public void testEmployee2() {
        EmployeeDAO e_dao = DAOFactory.getEmployeeDAO();
        ServiceDAO  s_dao = DAOFactory.getServiceDAO();
        
        Service s1 = s_dao.getById(1);
        Collection<Employee> col_e = e_dao.getByService(s1);
        assertEquals(col_e.size(), 1);
        assertEquals(col_e.iterator().next().getName().equals("Петров Андрей Алексеевич"), true);
    }  
    
    @Test
    public void testEmployeeEmail() {
        EmployeeDAO cc_dao = DAOFactory.getEmployeeDAO();
        EmployeeEmailDAO cce_dao = DAOFactory.getEmployeeEmailDAO();
        
        Employee cc1 = cc_dao.getById(1);
        Collection<EmployeeEmail> col_cce = cce_dao.getByEmployee(cc1);
        assertEquals(col_cce.size(), 1);
        assertEquals(col_cce.iterator().next().getEmail().equals("a.petrov@mail.ru"), true);
    }

    @Test
    public void testEmployeePhone() {
        EmployeeDAO cc_dao = DAOFactory.getEmployeeDAO();
        EmployeePhoneDAO cce_dao = DAOFactory.getEmployeePhoneDAO();
        
        Employee cc1 = cc_dao.getById(1);
        Collection<EmployeePhone> col_cce = cce_dao.getByEmployee(cc1);
        assertEquals(col_cce.size(), 1);
        assertEquals(col_cce.iterator().next().getPhone().equals("9676512312"), true);
    }

    @Test
    public void testService1() {
        ServiceDAO s_dao = DAOFactory.getServiceDAO();
        ServiceTypeDAO st_dao = DAOFactory.getServiceTypeDAO();
        
        ServiceType st1 = st_dao.getById(1);
        Collection<Service> col_s = s_dao.getByServiceType(st1);
        assertEquals(col_s.size(), 1);
        assertEquals(Math.abs(col_s.iterator().next().getCost() - 5000) < 1, true);
    }   

    @Test
    public void testService2() {
        ServiceDAO s_dao = DAOFactory.getServiceDAO();
        ClientDAO c_dao = DAOFactory.getClientDAO();
        
        Client c1 = c_dao.getById(1);
        Collection<Service> col_s = s_dao.getByClient(c1);
        assertEquals(col_s.size(), 1);
        assertEquals(Math.abs(col_s.iterator().next().getCost() - 5000) < 1, true);
    }   

    @Test
    public void testService3() {
        EmployeeDAO e_dao = DAOFactory.getEmployeeDAO();
        ServiceDAO  s_dao = DAOFactory.getServiceDAO();
        
        Employee e1 = e_dao.getById(1);
        Collection<Service> col_s = s_dao.getByEmployee(e1);
        assertEquals(col_s.size(), 1);
        assertEquals(Math.abs(col_s.iterator().next().getCost() - 5000) < 1, true);
    }

}
