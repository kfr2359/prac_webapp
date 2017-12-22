package logic;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

@Entity
@Table(name="service_employee")
public class ServiceEmployee implements Serializable{
    private static final long serialVersionUID = 8704271600371991112L;

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="serviceId")
    private Service service;
    
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="employeeId")
    private Employee employee;
    
    public ServiceEmployee() {}

    public ServiceEmployee(Service service, Employee employee) {
        super();
        this.service = service;
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}
