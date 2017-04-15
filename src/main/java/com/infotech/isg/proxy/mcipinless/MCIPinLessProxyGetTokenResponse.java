package com.infotech.isg.proxy.mcipinless;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlValue;

/**
 * representing MCIPinLess GetToken response object.
 *
 * @author Sevak Gahribian
 */
@XmlRootElement(name = "GetTokenResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class MCIPinLessProxyGetTokenResponse {
    @XmlValue
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return String.format("[%s]", token);
    }
}
