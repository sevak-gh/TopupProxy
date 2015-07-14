package com.infotech.isg.proxy.rightel;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * representing Rightel GetAccountBalance response object.
 *
 * @author Sevak Gharibian
 */
@XmlRootElement(name = "GetAccountBalanceResult")
public class RightelProxyGetAccountBalanceResponse extends RightelProxyResponse {

    @XmlElement(name = "Value")
    private String value;   

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("[code:%s, desc:%s, value:%s]", 
                             errorCode, errorDesc, value);
    }
}
