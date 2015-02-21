package com.infotech.isg.proxy.jiring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * implementation of proxy client for Jiring service.
 *
 * @author Sevak Gharibian
 */
public class JiringProxyImpl implements JiringProxy {

    private static final Logger LOG = LoggerFactory.getLogger(JiringProxyImpl.class);

    private static final String SALES_REQUEST_FUNCTION_NAME = "SALESREQUEST";
    private static final String SALES_REQUEST_EXEC_FUNCTION_NAME = "SALESREQUESTEXEC";
    private static final String BALANCE_FUNCTION_NAME = "BALANCE";
    private static final String SALES_REQUEST_EXEC_PARAM_2 = "APPROVE";

    private final String url;
    private final String username;
    private final String password;
    private final String brand;

    public JiringProxyImpl(String url, String username, String password, String brand) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.brand = brand;
    }

    @Override
    public TCSResponse salesRequest(String consumer, int amount) {
        TCSRequest request = new TCSRequest();
        request.setUsername(username);
        request.setPassword(password);
        request.setFunctionName(SALES_REQUEST_FUNCTION_NAME);
        request.setFunctionParam1(brand);
        request.setFunctionParam2(Integer.toString(amount));
        request.setFunctionParam4(username);
        request.setFunctionParam6(consumer);
        request.setFunctionParam7(consumer);
        TCSResponse response = TCSConnection.call(request, url);
        return response;
    }

    @Override
    public TCSResponse salesRequestExec(String token) {
        TCSRequest request = new TCSRequest();
        request.setUsername(username);
        request.setPassword(password);
        request.setFunctionName(SALES_REQUEST_EXEC_FUNCTION_NAME);
        request.setFunctionParam1(token);
        request.setFunctionParam2(SALES_REQUEST_EXEC_PARAM_2);
        TCSResponse response = TCSConnection.call(request, url);
        return response;
    }

    @Override
    public TCSResponse balance() {
        TCSRequest request = new TCSRequest();
        request.setUsername(username);
        request.setPassword(password);
        request.setFunctionName(BALANCE_FUNCTION_NAME);
        TCSResponse response = TCSConnection.call(request, url);
        return response;
    }
}
