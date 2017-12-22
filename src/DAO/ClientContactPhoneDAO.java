package DAO;

import logic.ClientContactPhone;
import logic.ClientContact;
import java.util.Collection;
import java.sql.SQLException;

public interface ClientContactPhoneDAO extends GenericDAO<ClientContactPhone> {
    public Collection<ClientContactPhone> getByClientContact(ClientContact clientContact);
}
