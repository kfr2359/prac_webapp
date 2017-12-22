package com.prac_webapp.DAO;

import com.prac_webapp.logic.EmployeeEmail;
import com.prac_webapp.logic.Employee;
import java.util.Collection;

public interface EmployeeEmailDAO extends GenericDAO<EmployeeEmail> {
    public Collection<EmployeeEmail> getByEmployee(Employee clientContact);
}
