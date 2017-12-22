package com.prac_webapp.tests;

import com.prac_webapp.DAO.*;
import com.prac_webapp.logic.*;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Iterator;

import org.testng.Assert;

public class TestDAOGeneric extends Assert {
    @Test
    public void testAddDelete() {
        ClientDAO client_dao = DAOFactory.getClientDAO();
        
        Client c1 = new Client();
        c1.setName("temp client");
        client_dao.add(c1);
        
        Collection<Client> cc = client_dao.getAll();
        boolean found = false;
        for (Iterator<Client> it = cc.iterator(); it.hasNext();) {
            Client c = it.next();

            if (c.getName().equals("temp client")) {
                found = true;
                break;
            }
        }
        assertEquals(found, true);
        
        client_dao.delete(c1);
    }

    @Test
    public void testUpdate() {
        ClientDAO client_dao = DAOFactory.getClientDAO();
        
        Client c1 = client_dao.getById(1);
        String temp = c1.getName();
        c1.setName("temp");
        client_dao.update(c1);

        Collection<Client> cc = client_dao.getAll();
        boolean found = false;
        for (Iterator<Client> it = cc.iterator(); it.hasNext();) {
            Client c = it.next();

            if (c.getName().equals("temp")) {
                found = true;
                break;
            }
        }
        assertEquals(found, true);

        c1.setName(temp);
        client_dao.update(c1);
    }
}
