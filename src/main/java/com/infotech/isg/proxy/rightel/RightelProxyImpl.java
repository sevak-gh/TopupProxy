package com.infotech.isg.proxy.rightel;

import com.infotech.isg.proxy.HashGenerator;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * implementation for Rightel proxy.
 *
 * @author Sevak Gharibian
 */
public class RightelProxyImpl implements RightelProxy {

    private static final Logger LOG = LoggerFactory.getLogger(RightelProxyImpl.class);

    private final String url;
    private final String username;
    private final String password;
    private final String namespace;

    public RightelProxyImpl(String url, String username, String password, String namespace) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.namespace = namespace;
    }

    @Override
    public RightelProxySubmitChargeRequestResponse submitChargeRequest(String consumer, int amount, int channel) {

        // create empty soap request, no soap action header
        SOAPMessage request = SOAPHelper.createSOAPRequest(namespace, null);

        // add request body/header
        try {
            SOAPHeader header = request.getSOAPHeader();
            SOAPHeaderElement headerElement = header.addHeaderElement(new QName(namespace, "AccountCredentials", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement usernameElement = headerElement.addChildElement(new QName(namespace, "username", SOAPHelper.NAMESPACE_PREFIX));
            usernameElement.setValue(username);
            SOAPElement passwordElement = headerElement.addChildElement(new QName(namespace, "password", SOAPHelper.NAMESPACE_PREFIX));
            passwordElement.setValue(password);
            SOAPBody body = request.getSOAPBody();
            SOAPBodyElement bodyElement = body.addBodyElement(new QName(namespace, "SubmitChargeRequest", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement element = bodyElement.addChildElement(new QName(namespace, "telno", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(consumer);
            element = bodyElement.addChildElement(new QName(namespace, "amount", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(Integer.toString(amount));
            element = bodyElement.addChildElement(new QName(namespace, "chargeChanel", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(Integer.toString(channel));
            request.saveChanges();
        } catch (SOAPException e) {
            throw new RuntimeException("soap extended request creation error", e);
        }

        // send message and get response
        SOAPMessage soapResponse = SOAPHelper.callSOAP(request, url);

        // process response
        RightelProxySubmitChargeRequestResponse response = SOAPHelper.parseResponse(soapResponse,
                                                                                    namespace,
                                                                                    "SubmitChargeRequestResponse",
                                                                                    RightelProxySubmitChargeRequestResponse.class);

        return response;
    }
    
    @Override
    public RightelProxyConfirmChargeRequestResponse confirmChargeRequest(String requestId, long trId) {

        // create empty soap request, no soap action header
        SOAPMessage request = SOAPHelper.createSOAPRequest(namespace, null);

        // add request body/header
        try {
            SOAPHeader header = request.getSOAPHeader();
            SOAPHeaderElement headerElement = header.addHeaderElement(new QName(namespace, "AccountCredentials", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement usernameElement = headerElement.addChildElement(new QName(namespace, "username", SOAPHelper.NAMESPACE_PREFIX));
            usernameElement.setValue(username);
            SOAPElement passwordElement = headerElement.addChildElement(new QName(namespace, "password", SOAPHelper.NAMESPACE_PREFIX));
            passwordElement.setValue(password);
            SOAPBody body = request.getSOAPBody();
            SOAPBodyElement bodyElement = body.addBodyElement(new QName(namespace, "ConfirmChargeRequest", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement element = bodyElement.addChildElement(new QName(namespace, "requestId", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(requestId);
            element = bodyElement.addChildElement(new QName(namespace, "transactionId", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode("Info" + Long.toString(trId));
            request.saveChanges();
        } catch (SOAPException e) {
            throw new RuntimeException("soap extended request creation error", e);
        }

        // send message and get response
        SOAPMessage soapResponse = SOAPHelper.callSOAP(request, url);

        // process response
        RightelProxyConfirmChargeRequestResponse response = SOAPHelper.parseResponse(soapResponse,
                                                                                     namespace,
                                                                                     "ConfirmChargeRequestResponse",
                                                                                     RightelProxyConfirmChargeRequestResponse.class);

        return response;
    }
    
    @Override
    public RightelProxyInquiryChargeResponse inquiryCharge(long trId) {
        // create empty soap request, no soap action header
        SOAPMessage request = SOAPHelper.createSOAPRequest(namespace, null);

        // add request body/header
        try {
            SOAPHeader header = request.getSOAPHeader();
            SOAPHeaderElement headerElement = header.addHeaderElement(new QName(namespace, "AccountCredentials", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement usernameElement = headerElement.addChildElement(new QName(namespace, "username", SOAPHelper.NAMESPACE_PREFIX));
            usernameElement.setValue(username);
            SOAPElement passwordElement = headerElement.addChildElement(new QName(namespace, "password", SOAPHelper.NAMESPACE_PREFIX));
            passwordElement.setValue(password);
            SOAPBody body = request.getSOAPBody();
            SOAPBodyElement bodyElement = body.addBodyElement(new QName(namespace, "InquiryCharge", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement element = bodyElement.addChildElement(new QName(namespace, "transactionId", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode("Info" + Long.toString(trId));
            request.saveChanges();
        } catch (SOAPException e) {
            throw new RuntimeException("soap extended request creation error", e);
        }

        // send message and get response
        SOAPMessage soapResponse = SOAPHelper.callSOAP(request, url);

        // process response
        RightelProxyInquiryChargeResponse response = SOAPHelper.parseResponse(soapResponse,
                                                                               namespace,
                                                                               "InquiryChargeResponse",
                                                                               RightelProxyInquiryChargeResponse.class);

        return response;           
    }   
    
    @Override
    public RightelProxyGetAccountBalanceResponse getAccountBalance() {
        // create empty soap request, no soap action header
        SOAPMessage request = SOAPHelper.createSOAPRequest(namespace, null);

        // add request body/header
        try {
            SOAPHeader header = request.getSOAPHeader();
            SOAPHeaderElement headerElement = header.addHeaderElement(new QName(namespace, "AccountCredentials", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement usernameElement = headerElement.addChildElement(new QName(namespace, "username", SOAPHelper.NAMESPACE_PREFIX));
            usernameElement.setValue(username);
            SOAPElement passwordElement = headerElement.addChildElement(new QName(namespace, "password", SOAPHelper.NAMESPACE_PREFIX));
            passwordElement.setValue(password);
            SOAPBody body = request.getSOAPBody();
            SOAPBodyElement bodyElement = body.addBodyElement(new QName(namespace, "GetAccountBalance", SOAPHelper.NAMESPACE_PREFIX));
            request.saveChanges();
        } catch (SOAPException e) {
            throw new RuntimeException("soap extended request creation error", e);
        }

        // send message and get response
        SOAPMessage soapResponse = SOAPHelper.callSOAP(request, url);

        // process response
        RightelProxyGetAccountBalanceResponse response = SOAPHelper.parseResponse(soapResponse,
                                                                                  namespace,
                                                                                  "GetAccountBalanceResponse",
                                                                                   RightelProxyGetAccountBalanceResponse.class);

        return response;
    }
}
