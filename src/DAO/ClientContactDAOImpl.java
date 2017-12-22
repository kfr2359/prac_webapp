package DAO;

import DAO.ClientContactDAO;
import DAO.GenericDAOImpl;
import logic.ClientContact;
import logic.Client;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Query;

public class ClientContactDAOImpl extends GenericDAOImpl<ClientContact> implements ClientContactDAO {    
    public ClientContactDAOImpl() {
        super(ClientContact.class);
    }

    public Collection<ClientContact> getByClient(Client client) {
        Session session = null;
        List<ClientContact> cce = new ArrayList<ClientContact>();
        try {
            int c_id = client.getId();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from ClientContact where client.id=:client_id").setInteger("client_id", c_id);
            cce = (List<ClientContact>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cce;
    }
}
