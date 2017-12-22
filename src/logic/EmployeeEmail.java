package logic;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

@Entity
@Table(name="employee_email")
public class EmployeeEmail implements Serializable {
    private static final long serialVersionUID = -5103938912901029009L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="employeeId")
    private Employee employee;
    
    private String email;
    
    public EmployeeEmail() {}
    public EmployeeEmail(int id, Employee employee, String email) {
        this.id = id;
        this.employee = employee;
        this.email = email;
    }
    
    public int  getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
