package com.infotech.isg.proxy.rightel;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * representing Rightel InquiryCharge response object.
 *
 * @author Sevak Gharibian
 */
@XmlRootElement(name = "InquiryChargeResult")
public class RightelProxyInquiryChargeResponse extends RightelProxyResponse {

    @XmlElement(name = "Id")
    private String requestId;   

    @XmlElement(name = "TelNo")
    private String telNo;

    @XmlElement(name = "Amount")
    private BigDecimal amount;

    @XmlElement(name = "Vat")
    private BigDecimal vat;

    @XmlElement(name = "Discount")
    private BigDecimal discount;

    @XmlElement(name = "BillAmount")
    private BigDecimal billAmount;

    @XmlElement(name = "BillState")
    private int billState;

    @XmlElement(name = "VoucherSerial")
    private String voucherSerial;

    @XmlElement(name = "ChargeTime")
    private String chargeTime;

    @XmlElement(name = "ChargeResponse")
    private String chargeResponse;

    @XmlElement(name = "ChargeResponseDesc")
    private String chargeResponseDesc;

    @XmlElement(name = "VerifyTime")
    private String verifyTime;

    @XmlElement(name = "VerifyResponse")
    private String verifyResponse;

    @XmlElement(name = "VerifyResponseDesc")
    private String verifyResponseDesc;

    @XmlElement(name = "TransactionId")
    private String transactionId;

    @XmlElement(name = "Status")
    private int status;

    @XmlElement(name = "StatusTime")
    private String statusTime;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getVat() {
       return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public int getBillState() {
        return billState;
    }

    public void setBillState(int billState) {
        this.billState = billState;
    }

    public String getVoucherSerial() {
        return voucherSerial;
    }

    public void setVoucherSerial(String voucherSerial) {
        this.voucherSerial = voucherSerial;
    }

    public String getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(String chargeTime) {
        this.chargeTime = chargeTime;
    }

    public String getChargeResponse() {
        return chargeResponse;
    }

    public void setChargeResponse(String chargeResponse) {
        this.chargeResponse = chargeResponse;
    }

    public String getChargeResponseDesc() {
        return chargeResponseDesc;
    }

    public void setChargeResponseDesc(String chargeResponseDesc) {
        this.chargeResponseDesc = chargeResponseDesc;
    }

    public String getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(String verifyTime) {
        this.verifyTime = verifyTime;
    }

    public String getVerifyResponse() {
        return verifyResponse;
    }

    public void setVerifyResponse(String verifyResponse) {
        this.verifyResponse = verifyResponse;
    }

    public String getVerifyResponseDesc() {
        return verifyResponseDesc;
    }

    public void setVerifyResponseDesc(String verifyResponseDesc) {
        this.verifyResponseDesc = verifyResponseDesc;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) { 
        this.status = status;
    }

    public String getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(String statusTime) {
        this.statusTime = statusTime;
    }

    @Override
    public String toString() {
        return String.format("[code:%s, desc:%s, requestId:%s, telNo:%s, amount:%s, vat:%s, discount:%s, billAmount:%s"
                             + ", billState:%d, voucherSerial:%s, chargeTime:%s, chargeResponse:%s, chargeResponseDesc: %s" 
                             + ", verifyTime:%s, verifyResponse:%s, verifyResponseDesc: %s, transactionId: %s, status:%s, statusTime: %s]", 
                             errorCode, errorDesc, requestId, telNo, amount, vat, discount, billAmount, billState, voucherSerial, chargeTime,
                             chargeResponse, chargeResponseDesc, verifyTime, verifyResponse, verifyResponseDesc, 
                             transactionId, status, statusTime);
    }
}
