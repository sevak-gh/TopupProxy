package com.infotech.isg.proxy.mtn;

import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;

/**
 * representing MTN general request object.
 *
 * @author Sevak Gharibian
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ETIRequest")
public class MTNProxyRequest {

    @XmlElement(name = "RequestMessage", namespace = "http://erefill.nokia.com")
    private String command;

    @XmlElement(name = "ClientID", namespace = "http://erefill.nokia.com")
    private String username;

    @XmlElement(name = "Password", namespace = "http://erefill.nokia.com")
    private String password;

    @XmlElement(name = "Parameters", namespace = "http://erefill.nokia.com")
    private Parameters parameters;

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Parameters {

        @XmlElement(name = "Parameter", namespace = "http://erefill.nokia.com")
        private List<Parameter> parameterList;

        public Parameters() {
            parameterList = new ArrayList<Parameter>();
        }

        public List<Parameter> getParameterList() {
            return parameterList;
        }

        public void setParameterList(List<Parameter> parameterList) {
            this.parameterList = parameterList;
        }

        public void add(Parameter parameter) {
            parameterList.add(parameter);
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Parameter {

        @XmlElement(name = "key", namespace = "http://erefill.nokia.com")
        private String key;

        @XmlElement(name = "value", namespace = "http://erefill.nokia.com")
        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("parameter[key:%s, value:%s]", key, value);
        }
    }

    public MTNProxyRequest() {
        parameters = new Parameters();
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addParameter(String key, String value) {
        Parameter parameter = new Parameter();
        parameter.setKey(key);
        parameter.setValue(value);
        parameters.add(parameter);
    }

    @Override
    public String toString() {
        return String.format("MTNRequest[command:%s, usernae:%s, password: %s, params: %s]",
                             command, username, password, parameters.toString());
    }
}
