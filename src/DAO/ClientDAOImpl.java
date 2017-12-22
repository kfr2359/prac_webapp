package DAO;

import DAO.ClientDAO;
import DAO.GenericDAOImpl;
import logic.Client;

public class ClientDAOImpl extends GenericDAOImpl<Client> implements ClientDAO {    
    public ClientDAOImpl() {
        super(Client.class);
    }

}
