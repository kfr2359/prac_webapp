package DAO;

import logic.Employee;
import logic.Job;
import logic.Service;

import java.util.Collection;
import java.sql.SQLException;

public interface EmployeeDAO extends GenericDAO<Employee> {
    public Collection<Employee> getByJob(Job job);
    public Collection<Employee> getByService(Service service);
}
