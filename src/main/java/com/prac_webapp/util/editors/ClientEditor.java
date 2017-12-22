package com.prac_webapp.util.editors;

import com.prac_webapp.DAO.ClientDAO;
import com.prac_webapp.DAO.DAOFactory;
import com.prac_webapp.DAO.JobDAO;
import com.prac_webapp.logic.Client;
import com.prac_webapp.logic.Job;

import java.beans.PropertyEditorSupport;

public class ClientEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String id) {
        ClientDAO clientDAO = DAOFactory.getClientDAO();
        Client client = clientDAO.getById(Integer.valueOf(id));
        this.setValue(client);
    }

    @Override
    public String getAsText() {
        Client client = (Client) this.getValue();
        return Integer.toString(client.getId());
    }
}
