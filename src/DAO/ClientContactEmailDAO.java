package DAO;

import logic.ClientContactEmail;
import logic.ClientContact;
import java.util.Collection;
import java.sql.SQLException;

public interface ClientContactEmailDAO extends GenericDAO<ClientContactEmail> {
    public Collection<ClientContactEmail> getByClientContact(ClientContact clientContact);
}
