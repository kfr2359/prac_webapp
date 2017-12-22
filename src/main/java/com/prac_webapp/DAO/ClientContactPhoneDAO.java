package com.prac_webapp.DAO;

import com.prac_webapp.logic.ClientContactPhone;
import com.prac_webapp.logic.ClientContact;
import java.util.Collection;

public interface ClientContactPhoneDAO extends GenericDAO<ClientContactPhone> {
    public Collection<ClientContactPhone> getByClientContact(ClientContact clientContact);
}
