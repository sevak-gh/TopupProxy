package com.infotech.isg.proxy.mtn;

import com.infotech.isg.proxy.SOAPHelper;

import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.namespace.QName;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * implementation for MTN proxy.
 *
 * @author Sevak Gharibian
 */
public class MTNProxyImpl implements MTNProxy {

    private static final Logger LOG = LoggerFactory.getLogger(MTNProxyImpl.class);

    private final String url;
    private final String username;
    private final String password;
    private final String vendor;
    private final String namespace;

    public MTNProxyImpl(String url, String username, String password, String vendor, String namespace) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.vendor = vendor;
        this.namespace = namespace;
    }

    @Override
    public MTNProxyResponse recharge(String consumer, int amount, long trId) {
        return serviceCall(String.format("%s:%d:%s|%s", consumer, amount, username, password), trId);
    }

    @Override
    public MTNProxyResponse billPayment(String consumer, int amount, long trId) {
        return serviceCall(String.format("pay:b:%s:%d:%s|%s", consumer, amount, username, password), trId);
    }

    @Override
    public MTNProxyResponse bulkTransfer(String consumer, int amount, long trId) {
        return serviceCall(String.format("pay:d:%s:%d:%s|%s", consumer, amount, username, password), trId);
    }

    @Override
    public MTNProxyResponse wow(String consumer, int amount, long trId) {
        return serviceCall(String.format("%s:%d:%s:19|%s", consumer, amount, username, password), trId);
    }

    @Override
    public MTNProxyResponse postPaidWimax(String consumer, int amount, long trId) {
        return serviceCall(String.format("%s:%d:%s|%s", consumer, amount, username, password), trId);
    }

    @Override
    public MTNProxyResponse prePaidWimax(String consumer, int amount, long trId) {
        return serviceCall(String.format("%s:%d:%s|%s", consumer, amount, username, password), trId);
    }

    @Override
    public MTNProxyResponse gprs(String consumer, int amount, long trId) {
        return serviceCall(String.format("%s:%d:%s:43|%s", consumer, amount, username, password), trId);
    }

    private MTNProxyResponse serviceCall(String command, long trId) {

        // create empty soap request
        SOAPMessage request = SOAPHelper.createSOAPRequest(namespace, null);

        // add request body/header
        try {
            SOAPBody body = request.getSOAPBody();
            SOAPBodyElement bodyElement = body.addBodyElement(new QName(namespace, "processRequest", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement etiElement = bodyElement.addChildElement("ETIRequest");
            SOAPElement element = etiElement.addChildElement(new QName(namespace, "RequestMessage", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(command);
            element = etiElement.addChildElement(new QName(namespace, "ClientID", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode("");
            element = etiElement.addChildElement(new QName(namespace, "Password", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode("");
            SOAPElement parameters = etiElement.addChildElement(new QName(namespace, "Parameters", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement parameter = parameters.addChildElement(new QName(namespace, "Parameter", SOAPHelper.NAMESPACE_PREFIX));
            element = parameter.addChildElement(new QName(namespace, "key", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode("ext_tid");
            element = parameter.addChildElement(new QName(namespace, "value", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode("info" + Long.toString(trId));
            parameter = parameters.addChildElement(new QName(namespace, "Parameter", SOAPHelper.NAMESPACE_PREFIX));
            element = parameter.addChildElement(new QName(namespace, "key", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode("ext_id");
            element = parameter.addChildElement(new QName(namespace, "value", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode("Internet");
            parameter = parameters.addChildElement(new QName(namespace, "Parameter", SOAPHelper.NAMESPACE_PREFIX));
            element = parameter.addChildElement(new QName(namespace, "key", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode("ext_name");
            element = parameter.addChildElement(new QName(namespace, "value", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(vendor);
            parameter = parameters.addChildElement(new QName(namespace, "Parameter", SOAPHelper.NAMESPACE_PREFIX));
            element = parameter.addChildElement(new QName(namespace, "key", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode("ext_date");
            element = parameter.addChildElement(new QName(namespace, "value", SOAPHelper.NAMESPACE_PREFIX));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            element.addTextNode(dateFormat.format(new Date()));
            request.saveChanges();
        } catch (SOAPException e) {
            throw new RuntimeException("soap extended request creation error", e);
        }

        // send message and get response
        SOAPMessage soapResponse = SOAPHelper.callSOAP(request, url);

        // process response
        MTNProxyResponse response = SOAPHelper.parseResponse(soapResponse,
                                    namespace,
                                    "processRequestResponse",
                                    MTNProxyResponse.class);

        return response;
    }
}
