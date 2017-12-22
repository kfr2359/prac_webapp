package com.prac_webapp.util.editors;

import com.prac_webapp.DAO.DAOFactory;
import com.prac_webapp.DAO.JobDAO;
import com.prac_webapp.logic.Job;

import java.beans.PropertyEditorSupport;

public class JobEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String id) {
        JobDAO jobDAO = DAOFactory.getJobDAO();
        Job job = jobDAO.getById(Integer.valueOf(id));
        this.setValue(job);
    }

    @Override
    public String getAsText() {
        Job job = (Job) this.getValue();
        return Integer.toString(job.getId());
    }
}
