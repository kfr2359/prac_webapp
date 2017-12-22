package DAO;

import logic.Client;
import logic.ClientContact;
import java.util.Collection;
import java.sql.SQLException;

public interface ClientContactDAO extends GenericDAO<ClientContact> {
    public Collection<ClientContact> getByClient(Client clientContact);
}
