package com.infotech.isg.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

/**
 * domain object representing payment channel.
 *
 * @author Sevak Gharibian
 */
@Entity
@Table(name = "info_topup_payment_channel")
public class PaymentChannel {

    private String id;
    private boolean isActive;
    private ActiveType active;

    @Id
    @Column(name="CHANNEL", nullable=false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        isActive = active == (ActiveType.Y) ? true : false;
    }

    @Override
    public String toString() {
        return String.format("[%s:%s]", id, (isActive) ? "Active" : "Disabled");
    }
}
