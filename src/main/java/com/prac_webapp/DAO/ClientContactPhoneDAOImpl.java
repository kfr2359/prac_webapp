package com.prac_webapp.DAO;

import com.prac_webapp.logic.ClientContactPhone;
import com.prac_webapp.logic.ClientContact;
import com.prac_webapp.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from ClientContactPhone where contact.id=:contact_id").setInteger("contact_id", cc_id);
            cce = (List<ClientContactPhone>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return cce;
    }
}
