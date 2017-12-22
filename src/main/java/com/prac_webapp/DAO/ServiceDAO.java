package com.prac_webapp.DAO;

import com.prac_webapp.logic.Service;
import com.prac_webapp.logic.ServiceType;
import com.prac_webapp.logic.Client;
import com.prac_webapp.logic.Employee;

import java.util.Collection;

public interface ServiceDAO extends GenericDAO<Service> {
    public Collection<Service> getByServiceType(ServiceType serviceType);
    public Collection<Service> getByClient     (Client client);
    public Collection<Service> getByEmployee   (Employee employee);
}
