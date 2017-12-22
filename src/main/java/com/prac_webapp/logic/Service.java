package com.prac_webapp.logic;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="service")
public class Service implements Serializable {
    private static final long serialVersionUID = -5378740398544969743L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int   id;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="typeId")
    private ServiceType type;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="clientId")
    private Client client;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="service_employee", joinColumns = { @JoinColumn(name="serviceId") },
            inverseJoinColumns = { @JoinColumn(name="employeeId") })
    private Set<Employee> employees = new HashSet<Employee>();

    private float cost;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date  startDate;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date  endDate;
    
    public Service() {}

    public Service(int id, ServiceType type, Client client, float cost, Date startDate, Date endDate) {
        this.id = id;
        this.type = type;
        this.client = client;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
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
        if (! (obj instanceof Service)) {
            return false;
        }
        return this.id == ((Service) obj).getId();
    }
    
}
