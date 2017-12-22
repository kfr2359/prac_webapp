package com.prac_webapp.DAO;

import com.prac_webapp.logic.Employee;
import com.prac_webapp.logic.Job;
import com.prac_webapp.logic.Service;

import java.util.Collection;

public interface EmployeeDAO extends GenericDAO<Employee> {
    public Collection<Employee> getByJob(Job job);
    public Collection<Employee> getByService(Service service);
}
