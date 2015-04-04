package com.infotech.isg.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;

/**
 * domain object representing ISG service client.
 *
 * @author Sevak Gharibian
 */
@NamedQueries({
    @NamedQuery(
    name = "findClientByUsername",
    query = "SELECT client FROM Client client left join fetch client.ips WHERE client.username = :username"
    )
})
@Entity
@Table(name = "info_topup_clients")
public class Client {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String contact;
    private String tel;
    private String vendor;
    private Date createdDate;
    private Date firstLoginDate;
    private Date lastLoginDate;
    private boolean isActive;
    private ActiveType active;
    private List<String> ips;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="CLIENT", nullable=false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="PIN", nullable=false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="VENDOR")
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Transient
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
        active = (isActive) ? ActiveType.Y : ActiveType.N;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="ACTIVE", nullable=false)
    public ActiveType getActive() {
        return active;
    }

    public void setActive(ActiveType active) {
        this.active = active;
        isActive = (active == ActiveType.Y) ? true : false;
    }

    @ElementCollection
    @CollectionTable(
        name="info_topup_client_ips",
        joinColumns=@JoinColumn(name="CLIENT")
    )
    @Column(name="IP")
    public List<String> getIps() {
        if (ips == null) {
            ips = new ArrayList<String>();
        }
        return ips;
    }

    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    public void addIp(String ip) {
        getIps().add(ip);
    }

    @Override
    public String toString() {
        return String.format("[%s:%s][%s]", username, (isActive) ? "Active" : "Disabled", getIps());
    }
}
