package com.prac_webapp.util.editors;

import com.prac_webapp.DAO.DAOFactory;
import com.prac_webapp.DAO.ServiceTypeDAO;
import com.prac_webapp.logic.ServiceType;

import java.beans.PropertyEditorSupport;

public class ServiceTypeEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String id) {
        ServiceTypeDAO serviceTypeDAO = DAOFactory.getServiceTypeDAO();
        ServiceType st = serviceTypeDAO.getById(Integer.valueOf(id));
        this.setValue(st);
    }

    @Override
    public String getAsText() {
        ServiceType st = (ServiceType) this.getValue();
        return Integer.toString(st.getId());
    }
}
