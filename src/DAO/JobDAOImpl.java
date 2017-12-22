package DAO;

import DAO.JobDAO;
import DAO.GenericDAOImpl;
import logic.Job;

public class JobDAOImpl extends GenericDAOImpl<Job> implements JobDAO {    
    public JobDAOImpl() {
        super(Job.class);
    }

}
