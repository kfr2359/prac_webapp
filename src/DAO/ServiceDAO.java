package DAO;

import logic.Service;
import logic.ServiceType;
import logic.Client;
import logic.Employee;

import java.util.Collection;
import java.sql.SQLException;

public interface ServiceDAO extends GenericDAO<Service> {
    public Collection<Service> getByServiceType(ServiceType serviceType);
    public Collection<Service> getByClient     (Client client);
    public Collection<Service> getByEmployee   (Employee employee);
}
