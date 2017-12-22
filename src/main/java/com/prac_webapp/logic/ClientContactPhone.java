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
@Table(name="client_contact_phone")
public class ClientContactPhone implements Serializable {
    private static final long serialVersionUID = -5678823869814091832L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="contactId")
    private ClientContact contact;
    
    private String phone;
    
    public ClientContactPhone() {}
    public ClientContactPhone(int id, ClientContact contact, String phone) {
        this.id = id;
        this.contact = contact;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
}
