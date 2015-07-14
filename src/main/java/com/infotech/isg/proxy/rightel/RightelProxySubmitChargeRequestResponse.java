package com.infotech.isg.proxy.rightel;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * representing Rightel SubmitChargeRequest response object.
 *
 * @author Sevak Gharibian
 */
@XmlRootElement(name = "SubmitChargeRequestResult")
public class RightelProxySubmitChargeRequestResponse extends RightelProxyResponse {

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

    @Override
    public String toString() {
        return String.format("[code:%s, desc:%s, requestId:%s, telNo:%s, amount:%s, vat:%s, discount:%s, billAmount:%s]", 
                             errorCode, errorDesc, requestId, telNo, amount, vat, discount, billAmount);
    }
}
