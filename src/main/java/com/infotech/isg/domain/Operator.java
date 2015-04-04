package com.infotech.isg.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

/**
 * domain object representing Telecom operator.
 *
 * @author Sevak Gharibian
 */
@Entity
@Table(name = "info_topup_operators")
public class Operator {

    public enum StatusType {
        active,
        disabled
    };

    private Integer id;
    private String name;
    private boolean isActive;
    private StatusType status;

    public static final int MTN_ID = 1;
    public static final int MCI_ID = 2;
    public static final int JIRING_ID = 3;

    @Id
    @Column(name="ID", nullable=false) 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transient
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
        status = (isActive) ? StatusType.active : StatusType.disabled;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="STATUS",nullable=false)
    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
        isActive = (status == StatusType.active) ? true : false;
    }

    @Override
    public String toString() {
        return String.format("[%s(%d):%s]", name, id, (isActive) ? "Active" : "Disabled");
    }

    public static String getName(int id) {
        switch (id) {
            case MTN_ID: return "MTN";
            case MCI_ID: return "MCI";
            case JIRING_ID: return "Jiring";
            default: return "";
        }
    }
}
