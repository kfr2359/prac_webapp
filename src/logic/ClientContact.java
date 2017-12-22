package logic;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

@Entity
@Table(name="client_contact" )
public class ClientContact implements Serializable {
    private static final long serialVersionUID = 1133102325281867441L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    id;
    private String name;
    private String address;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="clientId")
    private Client client;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="contact", cascade=CascadeType.REMOVE)
    private Set<ClientContactPhone> clientContactPhone = new HashSet<ClientContactPhone>();
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="contact", cascade=CascadeType.REMOVE)
    private Set<ClientContactEmail> clientContactEmail = new HashSet<ClientContactEmail>();
    
    
    public ClientContact() {}

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<ClientContactPhone> getClientContactPhone() {
        return clientContactPhone;
    }

    public void setClientContactPhone(Set<ClientContactPhone> clientContactPhone) {
        this.clientContactPhone = clientContactPhone;
    }

    public Set<ClientContactEmail> getClientContactEmail() {
        return clientContactEmail;
    }

    public void setClientContactEmail(Set<ClientContactEmail> clientContactEmail) {
        this.clientContactEmail = clientContactEmail;
    }
        
}
