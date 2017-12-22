package com.prac_webapp.DAO;

import com.prac_webapp.logic.ServiceType;

public class ServiceTypeDAOImpl extends GenericDAOImpl<ServiceType> implements ServiceTypeDAO {    
    public ServiceTypeDAOImpl() {
        super(ServiceType.class);
    }

}
