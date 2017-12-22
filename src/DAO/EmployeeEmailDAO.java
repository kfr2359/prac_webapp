package DAO;

import logic.EmployeeEmail;
import logic.Employee;
import java.util.Collection;
import java.sql.SQLException;

public interface EmployeeEmailDAO extends GenericDAO<EmployeeEmail> {
    public Collection<EmployeeEmail> getByEmployee(Employee clientContact);
}
