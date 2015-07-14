package com.infotech.isg.proxy.rightel;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;

/**
 * representing Rightel abstract response object.
 *
 * @author Sevak Gharibian
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class RightelProxyResponse {

    @XmlElement(name = "ErrorCode")
    protected int errorCode;

    @XmlElement(name = "ErrorDesc")
    protected String errorDesc;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }
}
