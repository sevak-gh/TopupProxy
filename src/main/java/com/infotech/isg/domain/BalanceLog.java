package com.infotech.isg.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * domain object representing isg balance log
 *
 * @author Sevak Gharibian
 */
@Entity
@Table(name = "info_topup_balance_log")
public class BalanceLog {

    private Integer id;
    private Long mci10000;
    private Long mci20000;
    private Long mci50000;
    private Long mci100000;
    private Long mci200000;
    private Long mci500000;
    private Long mci1000000;
    private Long mtn;
    private Long rightel;
    private Long jiring;
    private Date mci10000Timestamp;
    private Date mci20000Timestamp;
    private Date mci50000Timestamp;
    private Date mci100000Timestamp;
    private Date mci200000Timestamp;
    private Date mci500000Timestamp;
    private Date mci1000000Timestamp;
    private Date mtnTimestamp;
    private Date jiringTimestamp;
    private Date rightelTimestamp;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="MCI10000")
    public Long getMci10000() {
        return mci10000;
    }

    public void setMci10000(Long mci10000) {
        this.mci10000 = mci10000;
    }

    @Column(name="MCI20000")
    public Long getMci20000() {
        return mci20000;
    }

    public void setMci20000(Long mci20000) {
        this.mci20000 = mci20000;
    }

    @Column(name="MCI50000")
    public Long getMci50000() {
        return mci50000;
    }

    public void setMci50000(Long mci50000) {
        this.mci50000 = mci50000;
    }

    @Column(name="MCI100000")
    public Long getMci100000() {
        return mci100000;
    }

    public void setMci100000(Long mci100000) {
        this.mci100000 = mci100000;
    }

    @Column(name="MCI200000")
    public Long getMci200000() {
        return mci200000;
    }

    public void setMci200000(Long mci200000) {
        this.mci200000 = mci200000;
    }

    @Column(name="MCI500000")
    public Long getMci500000() {
        return mci500000;
    }

    public void setMci500000(Long mci500000) {
        this.mci500000 = mci500000;
    }

    @Column(name="MCI1000000")
    public Long getMci1000000() {
        return mci1000000;
    }

    public void setMci1000000(Long mci1000000) {
        this.mci1000000 = mci1000000;
    }

    @Column(name="MTN")
    public Long getMtn() {
        return mtn;
    }

    public void setMtn(Long mtn) {
        this.mtn = mtn;
    }

    @Column(name="Jiring")
    public Long getJiring() {
        return jiring;
    }

    public void setJiring(Long jiring) {
        this.jiring = jiring;
    }

    @Column(name="Rightel")
    public Long getRightel() {
        return rightel;
    }

    public void setRightel(Long rightel) {
        this.rightel = rightel;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MCI10000Timestamp")
    public Date getMci10000Timestamp() {
        return mci10000Timestamp;
    }

    public void setMci10000Timestamp(Date timestamp) {
        this.mci10000Timestamp = timestamp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MCI20000Timestamp")
    public Date getMci20000Timestamp() {
        return mci20000Timestamp;
    }

    public void setMci20000Timestamp(Date timestamp) {
        this.mci20000Timestamp = timestamp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MCI50000Timestamp")
    public Date getMci50000Timestamp() {
        return mci50000Timestamp;
    }

    public void setMci50000Timestamp(Date timestamp) {
        this.mci50000Timestamp = timestamp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MCI100000Timestamp")
    public Date getMci100000Timestamp() {
        return mci100000Timestamp;
    }

    public void setMci100000Timestamp(Date timestamp) {
        this.mci100000Timestamp = timestamp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MCI200000Timestamp")
    public Date getMci200000Timestamp() {
        return mci200000Timestamp;
    }

    public void setMci200000Timestamp(Date timestamp) {
        this.mci200000Timestamp = timestamp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MCI500000Timestamp")
    public Date getMci500000Timestamp() {
        return mci500000Timestamp;
    }

    public void setMci500000Timestamp(Date timestamp) {
        this.mci500000Timestamp = timestamp;
    }
 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MCI1000000Timestamp")
    public Date getMci1000000Timestamp() {
        return mci1000000Timestamp;
    }

    public void setMci1000000Timestamp(Date timestamp) {
        this.mci1000000Timestamp = timestamp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MTNTimestamp")
    public Date getMtnTimestamp() {
        return mtnTimestamp;
    }

    public void setMtnTimestamp(Date timestamp) {
        this.mtnTimestamp = timestamp;
    }
 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="JiringTimestamp")
    public Date getJiringTimestamp() {
        return jiringTimestamp;
    }

    public void setJiringTimestamp(Date timestamp) {
        this.jiringTimestamp = timestamp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="RightelTimestamp")
    public Date getRightelTimestamp() {
        return rightelTimestamp;
    }

    public void setRightelTimestamp(Date timestamp) {
        this.rightelTimestamp = timestamp;
    }

    @Override
    public String toString() {
        return String.format("BalanceLog[MCI1:%d, MCI2:%d, MCI5:%d, MCI10:%d, MCI20:%d, MCI50:%d, MCI100:%d, MTN:%d, Jiring:%d, Rightel: %d]",
                             mci10000,
                             mci20000,
                             mci50000,
                             mci100000,
                             mci200000,
                             mci500000,
                             mci1000000,
                             mtn,
                             jiring,
                             rightel);
    }
}
