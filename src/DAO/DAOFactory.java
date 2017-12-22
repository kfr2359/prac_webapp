package DAO;

public class DAOFactory {
    private static ClientContactDAO clientContactDAO = null;
    private static ClientContactEmailDAO clientContactEmailDAO = null;
    private static ClientContactPhoneDAO clientContactPhoneDAO = null;
    private static ClientDAO clientDAO = null;
    private static EmployeeDAO employeeDAO = null;
    private static EmployeePhoneDAO employeePhoneDAO = null;
    private static EmployeeEmailDAO employeeEmailDAO = null;
    private static JobDAO jobDAO = null;
    private static ServiceDAO serviceDAO = null;
    private static ServiceEmployeeDAO serviceEmployeeDAO = null;
    private static ServiceTypeDAO serviceTypeDAO = null;
    
    public static ClientContactDAO getClientContactDAO() {
        if (clientContactDAO == null) {
            clientContactDAO = new ClientContactDAOImpl();
        }
        return clientContactDAO;
    }
    public static ClientContactEmailDAO getClientContactEmailDAO() {
        if (clientContactEmailDAO == null) {
            clientContactEmailDAO = new ClientContactEmailDAOImpl();
        }
        return clientContactEmailDAO;
    }
    public static ClientContactPhoneDAO getClientContactPhoneDAO() {
        if (clientContactPhoneDAO == null) {
            clientContactPhoneDAO = new ClientContactPhoneDAOImpl();
        }
        return clientContactPhoneDAO;
    }
    public static ClientDAO getClientDAO() {
        if (clientDAO == null) {
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }
    public static EmployeeDAO getEmployeeDAO() {
        if (employeeDAO == null) {
            employeeDAO = new EmployeeDAOImpl();
        }
        return employeeDAO;
    }
    public static EmployeePhoneDAO getEmployeePhoneDAO() {
        if (employeePhoneDAO == null) {
            employeePhoneDAO = new EmployeePhoneDAOImpl();
        }
        return employeePhoneDAO;
    }
    public static EmployeeEmailDAO getEmployeeEmailDAO() {
        if (employeeEmailDAO == null) {
            employeeEmailDAO = new EmployeeEmailDAOImpl();
        }
        return employeeEmailDAO;
    }
    public static JobDAO getJobDAO() {
        if (jobDAO == null) {
            jobDAO = new JobDAOImpl();
        }
        return jobDAO;
    }
    public static ServiceDAO getServiceDAO() {
        if (serviceDAO == null) {
            serviceDAO = new ServiceDAOImpl();
        }
        return serviceDAO;
    }
    public static ServiceEmployeeDAO getServiceEmployeeDAO() {
        if (serviceEmployeeDAO == null) {
            serviceEmployeeDAO = new ServiceEmployeeDAOImpl();
        }
        return serviceEmployeeDAO;
    }
    public static ServiceTypeDAO getServiceTypeDAO() {
        if (serviceTypeDAO == null) {
            serviceTypeDAO = new ServiceTypeDAOImpl();
        }
        return serviceTypeDAO;
    }
    
    
}
