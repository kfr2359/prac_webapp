package com.prac_webapp.util.editors;

import com.prac_webapp.DAO.DAOFactory;
import com.prac_webapp.DAO.EmployeeDAO;
import com.prac_webapp.logic.Employee;

import java.beans.PropertyEditorSupport;

public class EmployeeEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String id) {
        EmployeeDAO eDAO = DAOFactory.getEmployeeDAO();
        Employee e = eDAO.getById(Integer.valueOf(id));
        this.setValue(e);
    }

    @Override
    public String getAsText() {
        Employee e = (Employee) this.getValue();
        return Integer.toString(e.getId());
    }
}
