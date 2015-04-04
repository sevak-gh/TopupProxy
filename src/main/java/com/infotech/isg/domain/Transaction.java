package com.infotech.isg.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * domain object representing topup transaction.
 *
 * @author Sevak Gharibian
 */
@NamedQueries({
    @NamedQuery(
    name = "findByRefNumBankCodeClientId",
    query = "SELECT transaction FROM Transaction transaction WHERE transaction.refNum = :refNum " +   
            "and transaction.bankCode = :bankCode and transaction.clientId = :clientId"
    ),
    @NamedQuery(
    name = "findByStfProvider",
    query = "SELECT transaction FROM Transaction transaction WHERE transaction.stf = :stf " +   
            "and transaction.provider = :provider"
    ),
    @NamedQuery(
    name = "findByProviderOperatorTId",
    query = "SELECT transaction FROM Transaction transaction WHERE transaction.provider = :provider " +   
            "and transaction.operatorTId = :operatorTId"
    )
})
@Entity
@Table(name = "info_topup_transactions")
public class Transaction {
    // auto-id
    private Long id;

    // service provider id, such as MTN=1, MCI=2, Jiring=3
    private int provider;

    // token received from MCI,Jiring in reponse to GET_Token request
    private String token;

    // action from request, column name = type
    private int action;

    // state prarmeter from request
    private String state;

    // orderId from request
    private String resNum;

    // bankReceipt/RRN from request
    private String refNum;

    // seems like not being used anymore
    private Long revNum;

    // remote IP makeing request, column name = clientip
    private String remoteIp;

    // amount from request, should be in valid range
    private long amount;

    // payment channel ID from request, should be defined active in DB
    private String channel;

    // consumer from request, means cell number
    private String consumer;

    // bankCode from request, should be valid
    private String bankCode;

    // client id defined in clients table, column name = client
    private int clientId;

    // customerIp from request
    private String customerIp;

    // current datetime once request receveived by ISG, column name = trtime
    private Date trDateTime;

    // filled by amount from request
    private Integer bankVerify;

    // filled by current datetime once request received by ISG, seems useless, column name = verifytime
    private Date verifyDateTime;

    // representing transaction/service result, 1=OK, otherwise=NOK{0,-1,-2,-3}
    private Integer status;

    // filled by response code from service provider, apparently 0=OK, otherwise=NOK, column name = operator
    private Integer operatorResponseCode;

    // filled by command status field from MTN request only, comumn name = oprcommand
    private String operatorCommand;

    // filled by response message/detail in service provider's response, column name = oprresponse
    private String operatorResponse;

    // fiiled by MTN/transctionId, MCI/response detail, Jiring/token, another words some additional info from response, column name = oprtid
    private String operatorTId;

    // filled by current datetime once response recevied from service provider, column name = operatortime
    private Date operatorDateTime;

    // =1 means this transaction is set to be processed by STF service, in case of failure.
    // =2 means stf checked and action was successfull.
    // =3 means stf checked and action was not successfull.
    private Integer stf;

    // apparently set by STF service
    private Integer stfResult;

    // seems like not being used anymore
    private Integer opReverse;

    // seems like not being used anymore
    private Integer bkReverse;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="PROVIDER", nullable=false)
    public int getProvider() {
        return provider;
    }

    public void setProvider(int provider) {
        this.provider = provider;
    }
    
    @Column(name="TOKEN")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name="TYPE", nullable=false)
    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    @Column(name="STATE", nullable=false)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name="REFNUM", nullable=false)
    public String getRefNum() {
        return refNum;
    }

    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    @Column(name="RESNUM", nullable=false)
    public String getResNum() {
        return resNum;
    }

    public void setResNum(String resNum) {
        this.resNum = resNum;
    }

    @Column(name="REVNUM")
    public Long getRevNum() {
        return revNum;
    }

    public void setRevNum(Long revNum) {
        this.revNum = revNum;
    }

    @Column(name="CLIENTIP", nullable=false)
    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    @Column(name="AMOUNT", nullable=false)
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
    
    @Column(name="CHANNEL", nullable=false)
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Column(name="CONSUMER", nullable=false)
    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    @Column(name="BANKCODE", nullable=false)
    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @Column(name="CLIENT", nullable=false)
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Column(name="CUSTOMERIP", nullable=false)
    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="TRTIME", nullable=false)
    public Date getTrDateTime() {
        return trDateTime;
    }

    public void setTrDateTime(Date trDateTime) {
        this.trDateTime = trDateTime;
    }

    @Column(name="BANKVERIFY")
    public Integer getBankVerify() {
        return bankVerify;
    }

    public void setBankVerify(Integer bankVerify) {
        this.bankVerify = bankVerify;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="VERIFYTIME")
    public Date getVerifyDateTime() {
        return verifyDateTime;
    }

    public void setVerifyDateTime(Date verifyDateTime) {
        this.verifyDateTime = verifyDateTime;
    }

    @Column(name="STATUS")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name="OPERATOR")
    public Integer getOperatorResponseCode() {
        return operatorResponseCode;
    }

    public void setOperatorResponseCode(Integer operatorResponseCode) {
        this.operatorResponseCode = operatorResponseCode;
    }

    @Column(name="OPRCOMMAND")
    public String getOperatorCommand() {
        return operatorCommand;
    }

    public void setOperatorCommand(String operatorCommand) {
        this.operatorCommand = operatorCommand;
    }

    @Column(name="OPRRESPONSE")
    public String getOperatorResponse() {
        return operatorResponse;
    }

    public void setOperatorResponse(String operatorResponse) {
        this.operatorResponse = operatorResponse;
    }

    @Column(name="OPRTID")
    public String getOperatorTId() {
        return operatorTId;
    }

    public void setOperatorTId(String operatorTId) {
        this.operatorTId = operatorTId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="OPERATORTIME")
    public Date getOperatorDateTime() {
        return operatorDateTime;
    }

    public void setOperatorDateTime(Date operatorDateTime) {
        this.operatorDateTime = operatorDateTime;
    }

    @Column(name="STF")
    public Integer getStf() {
        return stf;
    }

    public void setStf(Integer stf) {
        this.stf = stf;
    }

    @Column(name="STFRESULT")
    public Integer getStfResult() {
        return stfResult;
    }

    public void setStfResult(Integer stfResult) {
        this.stfResult = stfResult;
    }

    @Column(name="OPREVERSE")
    public Integer getOpReverse() {
        return opReverse;
    }

    public void setOpReverse(Integer opReverse) {
        this.opReverse = opReverse;
    }

    @Column(name="BKREVERSE")
    public Integer getBkReverse() {
        return bkReverse;
    }

    public void setBkReverse(Integer bkReverse) {
        this.bkReverse = bkReverse;
    }

    @Override
    public String toString() {
        return String.format("[%d:(%s,%d,%s)RRN:%s,status:%d,operatorResCode:%d,STF:%d(%s)]",
                             id, consumer, amount, Operator.getName(provider), refNum, status, operatorResponseCode, stf, trDateTime);
    }
}
