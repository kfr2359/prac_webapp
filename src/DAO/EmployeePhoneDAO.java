package DAO;

import logic.EmployeePhone;
import logic.Employee;
import java.util.Collection;
import java.sql.SQLException;

public interface EmployeePhoneDAO extends GenericDAO<EmployeePhone> {
    public Collection<EmployeePhone> getByEmployee(Employee clientContact);
}
