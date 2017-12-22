package com.prac_webapp.DAO;

import com.prac_webapp.logic.ClientContactEmail;
import com.prac_webapp.logic.ClientContact;
import java.util.Collection;

public interface ClientContactEmailDAO extends GenericDAO<ClientContactEmail> {
    public Collection<ClientContactEmail> getByClientContact(ClientContact clientContact);
}
