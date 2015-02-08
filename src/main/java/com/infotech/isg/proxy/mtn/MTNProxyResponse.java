package com.infotech.isg.proxy.mtn;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;

/**
 * representing MTN general response object.
 *
 * @author Sevak Gharibian
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ETIResponse")
public class MTNProxyResponse {

    @XmlElement(name = "TransactionID")
    private String transactionId;

    @XmlElement(name = "OrigResponseMessage")
    private String origResponseMessage;

    @XmlElement(name = "CommandStatus")
    private String commandStatus;

    @XmlElement(name = "ResultCode")
    private String resultCode;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrigResponseMessage() {
        return origResponseMessage;
    }

    public void setOrigResponseMessage(String origResponseMessage) {
        this.origResponseMessage = origResponseMessage;
    }

    public String getCommandStatus() {
        return commandStatus;
    }

    public void setCommandStatus(String commandStatus) {
        this.commandStatus = commandStatus;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return String.format("MTNResponse[trId:%s, origMsg:%s, cmdStatus: %s, rsltCode: %s]",
                             transactionId, origResponseMessage, commandStatus, resultCode);
    }
}
