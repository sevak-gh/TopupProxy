package com.infotech.isg.proxy.vopay;

import com.infotech.isg.proxy.HashGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.net.URLEncoder;
import java.util.Map;
import java.util.HashMap;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * proxy client impl for vopay service.
 *
 * @author Sevak Gharibian
 */
public class VopayProxyImpl implements VopayProxy {
    
    private static final Logger LOG = LoggerFactory.getLogger(VopayProxyImpl.class);

    private static final String ACCOUNT_INFO_PATH = "account_info";
    private static final String AVAILABLE_PACKAGES_PATH = "available_packages";
    private static final String PERFORM_TRANSACTION_PATH = "perform_transaction";

    private static final String REQUEST_ACCOUNT_ID = "AccountID";
    private static final String REQUEST_AGENT_ID = "AgentID";
    private static final String REQUEST_KEY = "Key";
    private static final String REQUEST_SIGNATURE = "Signature";
    private static final String REQUEST_PHONE_NUMBER = "PhoneNumber";
    private static final String REQUEST_RECIPIENT_PHONE_NUMBER = "RecipientPhoneNumber";
    private static final String REQUEST_PACKAGE = "Package";
    private static final String REQUEST_SENDER_NAME = "SenderName";
    private static final String REQUEST_SENDER_PHONE_NUMBER = "SenderPhoneNumber";
    private static final String REQUEST_SENDER_EMAIL = "SenderEmail";
    private static final String REQUEST_SENDER_MESSAGE = "SenderMessage";

    private final String url;
    private final String accountId;
    private final String agentId;
    private final String key;
    private final String secret;
    private final String authorizedIp;

    public VopayProxyImpl(String url, String accountId, String agentId, String key, String secret, String authorizedIp) {
        this.url = url;
        this.accountId = accountId;
        this.agentId = agentId;
        this.key = key;
        this.secret = secret;
        this.authorizedIp = authorizedIp;
    }

    @Override
    public VopayProxyAccountInfoResponse accountInfo() {
        VopayProxyAccountInfoResponse response = null;        
        String signature = getHashCode();
        Map<String, String> request = new HashMap<String, String>();
        request.put(REQUEST_ACCOUNT_ID, accountId);
        request.put(REQUEST_AGENT_ID, agentId);
        request.put(REQUEST_KEY, key);
        request.put(REQUEST_SIGNATURE, signature);
        String requestEncoded = encode(request);
        response = VopayProxyHelper.call(requestEncoded, url + ACCOUNT_INFO_PATH, VopayProxyAccountInfoResponse.class);
        return response; 
    }

    @Override
    public VopayProxyAvailablePackagesResponse availablePackages(String phoneNumber) {
        VopayProxyAvailablePackagesResponse response = null;        
        String signature = getHashCode();
        Map<String, String> request = new HashMap<String, String>();
        request.put(REQUEST_ACCOUNT_ID, accountId);
        request.put(REQUEST_AGENT_ID, agentId);
        request.put(REQUEST_KEY, key);
        request.put(REQUEST_SIGNATURE, signature);
        request.put(REQUEST_PHONE_NUMBER, phoneNumber);
        String requestEncoded = encode(request);
        response = VopayProxyHelper.call(requestEncoded, url + AVAILABLE_PACKAGES_PATH, VopayProxyAvailablePackagesResponse.class);
        return response; 
    }

    @Override
    public VopayProxyPerformTransactionResponse performTransaction(String recipientPhoneNumber,
                                                                   String packageName,
                                                                   String senderName,
                                                                   String senderPhoneNumber,
                                                                   String senderEmail,
                                                                   String senderMessage) {  
        VopayProxyPerformTransactionResponse response = null;        
        String signature = getHashCode();
        Map<String, String> request = new HashMap<String, String>();
        request.put(REQUEST_ACCOUNT_ID, accountId);
        request.put(REQUEST_AGENT_ID, agentId);
        request.put(REQUEST_KEY, key);
        request.put(REQUEST_SIGNATURE, signature);
        request.put(REQUEST_RECIPIENT_PHONE_NUMBER, recipientPhoneNumber);
        request.put(REQUEST_PACKAGE, packageName);
        request.put(REQUEST_SENDER_NAME, senderName);
        if (senderPhoneNumber != null) {
            request.put(REQUEST_SENDER_PHONE_NUMBER, senderPhoneNumber);
        }
        if (senderEmail != null) {
            request.put(REQUEST_SENDER_EMAIL, senderEmail);
        }
        if (senderMessage != null) {
            request.put(REQUEST_SENDER_MESSAGE, senderMessage);
        }
        String requestEncoded = encode(request);
        response = VopayProxyHelper.call(requestEncoded, url + PERFORM_TRANSACTION_PATH, VopayProxyPerformTransactionResponse.class);
        return response; 
   }

    private String getHashCode() {        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");        
        String input = key + secret + authorizedIp + formatter.format(new Date());
        return HashGenerator.getMD5(input);
    }

    private String encode(Map<String, String> data) {
        StringBuilder sb = new StringBuilder();
        for (String name : data.keySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            try {
                sb.append(String.format("%s=%s", name, URLEncoder.encode(String.valueOf(data.get(name)), "utf8")));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("error while encoding vopay request", e);
            }
        }
        return sb.toString();
    }
}
