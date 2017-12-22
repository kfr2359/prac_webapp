package DAO;

import DAO.ClientContactPhoneDAO;
import DAO.GenericDAOImpl;
import logic.ClientContactPhone;
import logic.ClientContact;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Query;

public class ClientContactPhoneDAOImpl extends GenericDAOImpl<ClientContactPhone> implements ClientContactPhoneDAO {
    
    public ClientContactPhoneDAOImpl() {
        super(ClientContactPhone.class);
    }

    public Collection<ClientContactPhone> getByClientContact(ClientContact clientContact) {
        Session session = null;
        List<ClientContactPhone> cce = new ArrayList<ClientContactPhone>();
        try {
            int cc_id = clientContact.getId();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from ClientContactPhone where contact.id=:contact_id").setInteger("contact_id", cc_id);
            cce = (List<ClientContactPhone>) query.list();
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
