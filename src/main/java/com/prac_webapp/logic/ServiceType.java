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
@Table(name="service_type")
public class ServiceType implements Serializable {
    private static final long serialVersionUID = -473051643822128488L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    private String name;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="type", cascade=CascadeType.REMOVE)
    private Set<Service> service = new HashSet<Service>();
    
    public ServiceType() {}

    public ServiceType(int id, String name) {
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

    public Set<Service> getService() {
        return service;
    }

    public void setService(Set<Service> service) {
        this.service = service;
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
        if (! (obj instanceof ServiceType)) {
            return false;
        }
        return this.id == ((ServiceType) obj).getId();
    }
}
