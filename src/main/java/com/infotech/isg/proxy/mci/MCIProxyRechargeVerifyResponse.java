package com.infotech.isg.proxy.mci;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * representing MCI Recharge Verify response object.
 *
 * @author Sevak Gharibian
 */
@XmlRootElement(name = "RechargeVerifyResult")
public class MCIProxyRechargeVerifyResponse extends MCIProxyResponse {

    public String getTrCode() {
        return response.get(2);
    }

    public String getTrDetail() {
        return response.get(3);
    }

    public String getTrDate() {
        return response.get(4);
    }

    public String getTrTime() {
        return response.get(5);
    }

    public String getTrSerial() {
        return response.get(6);
    }
}
