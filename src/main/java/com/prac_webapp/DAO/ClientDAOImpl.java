package com.prac_webapp.DAO;

import com.prac_webapp.logic.Client;

public class ClientDAOImpl extends GenericDAOImpl<Client> implements ClientDAO {    
    public ClientDAOImpl() {
        super(Client.class);
    }

}
