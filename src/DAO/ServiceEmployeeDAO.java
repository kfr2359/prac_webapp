package DAO;

import logic.ServiceEmployee;
import logic.Service;
import logic.Employee;
import java.util.Collection;
import java.sql.SQLException;

public interface ServiceEmployeeDAO extends GenericDAO<ServiceEmployee> {
    public Collection<ServiceEmployee> getByService (Service service);
    public Collection<ServiceEmployee> getByEmployee(Employee employee);
}
