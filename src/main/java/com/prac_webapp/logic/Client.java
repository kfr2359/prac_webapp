package com.prac_webapp.logic;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

@Entity
@Table(name="client")
public class Client implements Serializable {
    private static final long serialVersionUID = -1826512834960568180L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    
    private String name;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="client", cascade=CascadeType.REMOVE)
    private Set<ClientContact> clientContact = new HashSet<ClientContact>();

    @OneToMany(fetch=FetchType.LAZY, mappedBy="client", cascade=CascadeType.REMOVE)
    private Set<Service> service = new HashSet<Service>();
    
    public Client() {}

    public Client(int id, String name) {
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

    public Set<ClientContact> getClientContact() {
        return clientContact;
    }

    public void setClientContact(Set<ClientContact> clientContact) {
        this.clientContact = clientContact;
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
        if (! (obj instanceof Client)) {
            return false;
        }
        return this.id == ((Client) obj).getId();
    }
}
