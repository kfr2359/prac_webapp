package com.prac_webapp.DAO;

import com.prac_webapp.logic.Client;
import com.prac_webapp.logic.ClientContact;
import java.util.Collection;

public interface ClientContactDAO extends GenericDAO<ClientContact> {
    public Collection<ClientContact> getByClient(Client clientContact);
}
