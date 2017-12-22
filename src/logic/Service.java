package logic;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

@Entity
@Table(name="service")
public class Service implements Serializable {
    private static final long serialVersionUID = -5378740398544969743L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int   id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="typeId")
    private ServiceType type;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="clientId")
    private Client client;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="service", cascade=CascadeType.REMOVE)
    private Set<ServiceEmployee> serviceEmployee = new HashSet<ServiceEmployee>();
    
    private float cost;
    private Date  startDate;
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
    
    
    
}
