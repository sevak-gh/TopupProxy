package com.infotech.isg.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * domain object representing oprtaot status.
 *
 * @author Sevak Gharibian
 */
@Entity
@Table(name = "info_topup_operator_last_status")
public class OperatorStatus {

    public enum StatusType {
        READY,
        DOWN
    }

    private Integer id;
    private Date timestamp;
    private StatusType status;
    private boolean isAvailable;

    @Id
    @Column(name="id", nullable=false)
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Transient
    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
        status = (isAvailable) ? StatusType.READY : StatusType.DOWN;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable=false)
    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
        isAvailable = (status == StatusType.READY) ? true : false;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="timestamp", nullable=false)
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return String.format("OperatorStatus[id:%d, isAvailable:%s, timestamp: %s]", id, Boolean.toString(isAvailable), timestamp.toString());
    }
}
