package com.infotech.isg.proxy.mcipinless;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;

/**
 * representing MCIPinLess abstract response object.
 *
 * @author Sevak Gharibian
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class MCIPinLessProxyResponse {

    @XmlElement(name = "string")
    protected List<String> response;

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }

    public String getCode() {
        return response.get(0);
    }

    public String getDetail() {
        return response.get(1);
    }

    @Override
    public String toString() {
        return response.toString();
    }
}
