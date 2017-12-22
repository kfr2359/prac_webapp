package com.prac_webapp.DAO;

import com.prac_webapp.logic.Job;

public class JobDAOImpl extends GenericDAOImpl<Job> implements JobDAO {    
    public JobDAOImpl() {
        super(Job.class);
    }

}
