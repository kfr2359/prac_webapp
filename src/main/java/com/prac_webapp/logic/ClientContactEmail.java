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
@Table(name="client_contact_email")
public class ClientContactEmail implements Serializable {
    private static final long serialVersionUID = 564404336775350248L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="contactId")
    private ClientContact contact;
    
    private String email;
    
    public ClientContactEmail() {}

    public ClientContactEmail(int id, ClientContact contact, String email) {
        this.id = id;
        this.contact = contact;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public ClientContact getContact() {
        return contact;
    }
    public void setContact(ClientContact contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
