package com.infotech.isg.proxy.mcipinless;

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
 * implementation for MCIPinLess proxy.
 *
 * @author Sevak Gharibian
 */
public class MCIPinLessProxyImpl implements MCIPinLessProxy {

    private static final Logger LOG = LoggerFactory.getLogger(MCIPinLessProxyImpl.class);

    private static final String SOAPACTION_GET_TOKEN = "GetToken";
    private static final String SOAPACTION_CALL_SALE_PROVIDER = "CallSaleProvider";
    private static final String SOAPACTION_EXEC_SALE_PROVIDER = "ExecSaleProvider";
    private static final String SOAPACTION_REMAIN_CREDIT_INQUIRY = "RemainCreditInquiry";
    private static final String SOAPACTION_CHARGE_STATUS_INQUERY = "ChargeStatusInquery";

    private final String url;
    private final String username;
    private final String password;
    private final String namespace;

    public MCIPinLessProxyImpl(String url, String username, String password, String namespace) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.namespace = namespace;
    }

    @Override
    public MCIPinLessProxyGetTokenResponse getToken() {

        // create empty soap request
        SOAPMessage request = SOAPHelper.createSOAPRequest(namespace, namespace + SOAPACTION_GET_TOKEN);

        // send message and get response
        SOAPMessage response = SOAPHelper.callSOAP(request, url);

        // process response
        MCIPinLessProxyGetTokenResponse getTokenResponse = SOAPHelper.parseResponse(response, 
                                                                                    namespace, 
                                                                                    "GetTokenResponse", 
                                                                                    MCIPinLessProxyGetTokenResponse.class);

        return getTokenResponse;
    }

    @Override
    public MCIPinLessProxyCallSaleProviderResponse callSaleProvider(String token, String consumer, int amount) {

        // create empty soap request
        SOAPMessage request = SOAPHelper.createSOAPRequest(namespace, namespace + SOAPACTION_CALL_SALE_PROVIDER);

        // add request body/header
        try {
            SOAPHeader header = request.getSOAPHeader();
            SOAPHeaderElement headerElement = header.addHeaderElement(new QName(namespace, "AuthHeader", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement usernameElement = headerElement.addChildElement(new QName(namespace, "UserName", SOAPHelper.NAMESPACE_PREFIX));
            usernameElement.setValue(username);
            SOAPElement passwordElement = headerElement.addChildElement(new QName(namespace, "Password", SOAPHelper.NAMESPACE_PREFIX));
            String combination = username.toUpperCase() + "|" + password + "|" + token;
            passwordElement.setValue(HashGenerator.getMD5(combination));
            SOAPBody body = request.getSOAPBody();
            SOAPBodyElement bodyElement = body.addBodyElement(new QName(namespace, SOAPACTION_CALL_SALE_PROVIDER, SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement element = bodyElement.addChildElement(new QName(namespace, "TelNum", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(consumer);
            element = bodyElement.addChildElement(new QName(namespace, "TelCharger", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(consumer);
            element = bodyElement.addChildElement(new QName(namespace, "Amount", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(Integer.toString(amount));
            element = bodyElement.addChildElement(new QName(namespace, "ChargeType", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode("1001");
            element = bodyElement.addChildElement(new QName(namespace, "BrokerId", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(username);
            request.saveChanges();
        } catch (SOAPException e) {
            throw new RuntimeException("soap extended request creation error", e);
        }

        // send message and get response
        SOAPMessage soapResponse = SOAPHelper.callSOAP(request, url);

        // process response
        MCIPinLessProxyCallSaleProviderResponse response = SOAPHelper.parseResponse(soapResponse,
                                                                                    namespace,
                                                                                    "CallSaleProviderResponse",
                                                                                    MCIPinLessProxyCallSaleProviderResponse.class);

        return response;
    }

    @Override
    public MCIPinLessProxyExecSaleProviderResponse execSaleProvider(String token, String providerId, String bankCode) {

        // create empty soap request
        SOAPMessage request = SOAPHelper.createSOAPRequest(namespace, namespace + SOAPACTION_EXEC_SALE_PROVIDER);

        // add request body/header
        try {
            SOAPHeader header = request.getSOAPHeader();
            SOAPHeaderElement headerElement = header.addHeaderElement(new QName(namespace, "AuthHeader", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement usernameElement = headerElement.addChildElement(new QName(namespace, "UserName", SOAPHelper.NAMESPACE_PREFIX));
            usernameElement.setValue(username);
            SOAPElement passwordElement = headerElement.addChildElement(new QName(namespace, "Password", SOAPHelper.NAMESPACE_PREFIX));
            String combination = username.toUpperCase() + "|" + password + "|" + token;
            passwordElement.setValue(HashGenerator.getMD5(combination));
            SOAPBody body = request.getSOAPBody();
            SOAPBodyElement bodyElement = body.addBodyElement(new QName(namespace, SOAPACTION_EXEC_SALE_PROVIDER, SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement element = bodyElement.addChildElement(new QName(namespace, "ProviderID", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(providerId);
            element = bodyElement.addChildElement(new QName(namespace, "BankCode", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(bankCode);
            request.saveChanges();
        } catch (SOAPException e) {
            throw new RuntimeException("soap extended request creation error", e);
        }

        // send message and get response
        SOAPMessage soapResponse = SOAPHelper.callSOAP(request, url);

        // process response
        MCIPinLessProxyExecSaleProviderResponse response = SOAPHelper.parseResponse(soapResponse,
                                                                                    namespace,
                                                                                    "ExecSaleProviderResponse",
                                                                                    MCIPinLessProxyExecSaleProviderResponse.class);

        return response;
    }

    @Override
    public MCIPinLessProxyRemainCreditInquiryResponse remainCreditInquiry(String token) {

        // create empty soap request
        SOAPMessage request = SOAPHelper.createSOAPRequest(namespace, namespace + SOAPACTION_REMAIN_CREDIT_INQUIRY);

        // add request body/header
        try {
            SOAPHeader header = request.getSOAPHeader();
            SOAPHeaderElement headerElement = header.addHeaderElement(new QName(namespace, "AuthHeader", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement usernameElement = headerElement.addChildElement(new QName(namespace, "UserName", SOAPHelper.NAMESPACE_PREFIX));
            usernameElement.setValue(username);
            SOAPElement passwordElement = headerElement.addChildElement(new QName(namespace, "Password", SOAPHelper.NAMESPACE_PREFIX));
            String combination = username.toUpperCase() + "|" + password + "|" + token;
            passwordElement.setValue(HashGenerator.getMD5(combination));
            SOAPBody body = request.getSOAPBody();
            SOAPBodyElement bodyElement = body.addBodyElement(new QName(namespace, SOAPACTION_REMAIN_CREDIT_INQUIRY,SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement element = bodyElement.addChildElement(new QName(namespace, "BrokerID", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(username);
            request.saveChanges();
        } catch (SOAPException e) {
            throw new RuntimeException("soap extended request creation error", e);
        }

        // send message and get response
        SOAPMessage soapResponse = SOAPHelper.callSOAP(request, url);

        // process response
        MCIPinLessProxyRemainCreditInquiryResponse response = SOAPHelper.parseResponse(soapResponse,
                                                                                        namespace,
                                                                                        "RemainCreditInquiryResponse",
                                                                                        MCIPinLessProxyRemainCreditInquiryResponse.class);

        return response;
    }

    @Override
    public MCIPinLessProxyChargeStatusInqueryResponse chargeStatusInquery(String token, String consumer, String providerId, String bankCode) {

        // create empty soap request
        SOAPMessage request = SOAPHelper.createSOAPRequest(namespace, namespace + SOAPACTION_CHARGE_STATUS_INQUERY);

        // add request body/header
        try {
            SOAPHeader header = request.getSOAPHeader();
            SOAPHeaderElement headerElement = header.addHeaderElement(new QName(namespace, "AuthHeader", SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement usernameElement = headerElement.addChildElement(new QName(namespace, "UserName", SOAPHelper.NAMESPACE_PREFIX));
            usernameElement.setValue(username);
            SOAPElement passwordElement = headerElement.addChildElement(new QName(namespace, "Password", SOAPHelper.NAMESPACE_PREFIX));
            String combination = username.toUpperCase() + "|" + password + "|" + token;
            passwordElement.setValue(HashGenerator.getMD5(combination));
            SOAPBody body = request.getSOAPBody();
            SOAPBodyElement bodyElement = body.addBodyElement(new QName(namespace, SOAPACTION_CHARGE_STATUS_INQUERY,SOAPHelper.NAMESPACE_PREFIX));
            SOAPElement element = bodyElement.addChildElement(new QName(namespace, "BrokerID", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(username);
            element = bodyElement.addChildElement(new QName(namespace, "TelNum", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(consumer);
            element = bodyElement.addChildElement(new QName(namespace, "ProviderId", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(providerId);
            element = bodyElement.addChildElement(new QName(namespace, "Bank", SOAPHelper.NAMESPACE_PREFIX));
            element.addTextNode(bankCode);
            request.saveChanges();
        } catch (SOAPException e) {
            throw new RuntimeException("soap extended request creation error", e);
        }

        // send message and get response
        SOAPMessage soapResponse = SOAPHelper.callSOAP(request, url);

        // process response
        MCIPinLessProxyChargeStatusInqueryResponse response = SOAPHelper.parseResponse(soapResponse,
                                                                                       namespace,
                                                                                       "ChargeStatusInqueryResponse",
                                                                                        MCIPinLessProxyChargeStatusInqueryResponse.class);

        return response;
    }
}
