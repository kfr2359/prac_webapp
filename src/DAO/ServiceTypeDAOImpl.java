package DAO;

import DAO.ServiceTypeDAO;
import DAO.GenericDAOImpl;
import logic.ServiceType;

public class ServiceTypeDAOImpl extends GenericDAOImpl<ServiceType> implements ServiceTypeDAO {    
    public ServiceTypeDAOImpl() {
        super(ServiceType.class);
    }

}
