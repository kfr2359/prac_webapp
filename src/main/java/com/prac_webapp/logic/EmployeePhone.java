package com.prac_webapp.logic;

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
@Table(name="employee_phone")
public class EmployeePhone implements Serializable {
    private static final long serialVersionUID = -5136734851365057586L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="employeeId")
    private Employee employee;
    
    private String phone;
    
    public EmployeePhone() {}
    public EmployeePhone(int id, Employee employee, String phone) {
        this.id = id;
        this.employee = employee;
        this.phone = phone;
    }

    public int getId() {
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

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
