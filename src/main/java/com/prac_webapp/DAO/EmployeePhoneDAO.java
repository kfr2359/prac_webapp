package com.prac_webapp.DAO;

import com.prac_webapp.logic.EmployeePhone;
import com.prac_webapp.logic.Employee;
import java.util.Collection;

public interface EmployeePhoneDAO extends GenericDAO<EmployeePhone> {
    public Collection<EmployeePhone> getByEmployee(Employee clientContact);
}
