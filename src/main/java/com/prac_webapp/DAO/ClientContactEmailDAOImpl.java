package com.prac_webapp.DAO;

import com.prac_webapp.logic.ClientContactEmail;
import com.prac_webapp.logic.ClientContact;
import com.prac_webapp.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;

public class ClientContactEmailDAOImpl extends GenericDAOImpl<ClientContactEmail> implements ClientContactEmailDAO {
    
    public ClientContactEmailDAOImpl() {
        super(ClientContactEmail.class);
    }

    public Collection<ClientContactEmail> getByClientContact(ClientContact clientContact) {
        Session session = null;
        List<ClientContactEmail> cce = new ArrayList<ClientContactEmail>();
        try {
            int cc_id = clientContact.getId();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from ClientContactEmail where contact.id=:contact_id").setInteger("contact_id", cc_id);
            cce = (List<ClientContactEmail>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return cce;
    }
}
