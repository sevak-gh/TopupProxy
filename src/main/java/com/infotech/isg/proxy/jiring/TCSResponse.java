package com.infotech.isg.proxy.jiring;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;


/**
 * representing TCS response for jiring.
 *
 * @author Sevak Gharibian
 */
@XmlRootElement(name = "TCSReply")
@XmlAccessorType(XmlAccessType.FIELD)
public class TCSResponse {

    @XmlElement(name = "Result")
    private String result;

    @XmlElement(name = "Message")
    private String message;

    @XmlElement(name = "param1")
    private String param1;

    @XmlElement(name = "param2")
    private String param2;

    @XmlElement(name = "param3")
    private String param3;

    @XmlElement(name = "param4")
    private String param4;

    public void setResult(String result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public String getParam1() {
        return param1;
    }

    public String getParam2() {
        return param2;
    }

    public String getParam3() {
        return param3;
    }

    public String getParam4() {
        return param4;
    }

    @Override
    public String toString() {
        return String.format("TCSResponse[result:%s, message:%s, param1:%s]",
                             result, message, param1);
    }
}
