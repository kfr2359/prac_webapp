package com.prac_webapp.logic;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

@Entity
@Table(name="job")
public class Job implements Serializable {
    private static final long serialVersionUID = -9091941107843408726L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    private String name;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="job", cascade=CascadeType.REMOVE)
    private Set<Employee> employee = new HashSet<Employee>();
    
    public Job() {}

    public Job(int id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
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
        if (! (obj instanceof Job)) {
            return false;
        }
        return this.id == ((Job) obj).getId();
    }
}
