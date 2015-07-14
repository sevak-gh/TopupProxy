package com.infotech.isg.proxy.rightel;

/**
 * proxy client for Rightel service.
 *
 * @author Sevak Gharibian
 */
public interface RightelProxy {
    public RightelProxySubmitChargeRequestResponse submitChargeRequest(String consumer, int amount);
    public RightelProxyConfirmChargeRequestResponse confirmChargeRequest(String requestId, long trId);
    public RightelProxyInquiryChargeResponse inquiryCharge(long trId);
    public RightelProxyGetAccountBalanceResponse getAccountBalance();
}
