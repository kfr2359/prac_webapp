package com.prac_webapp.logic;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1932663796488389589L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    
    private String name;
    private String address;
    private String education;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="jobId")
    private Job    job;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="employee", cascade=CascadeType.REMOVE)
    private Set<EmployeePhone> employeePhone = new HashSet<EmployeePhone>();
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="employee", cascade=CascadeType.REMOVE)
    private Set<EmployeeEmail> employeeEmail = new HashSet<EmployeeEmail>();

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="employees")
    private Set<Service> services = new HashSet<Service>();
    
    public Employee() {}

    public Employee(int id, String name, String address, String education, Job job) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.education = education;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Set<EmployeePhone> getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(Set<EmployeePhone> employeePhone) {
        this.employeePhone = employeePhone;
    }

    public Set<EmployeeEmail> getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(Set<EmployeeEmail> employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }


    @Override
    public int hashCode() {
        return new Long(id).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Employee)) {
            return false;
        }
        return this.id == ((Employee)obj).getId();
    }
}
