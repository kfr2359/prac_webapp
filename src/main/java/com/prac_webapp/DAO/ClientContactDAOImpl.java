package com.prac_webapp.DAO;

import com.prac_webapp.logic.ClientContact;
import com.prac_webapp.logic.Client;
import com.prac_webapp.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from ClientContact where client.id=:client_id").setInteger("client_id", c_id);
            cce = (List<ClientContact>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return cce;
    }
}
