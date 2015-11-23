package com.infotech.isg.proxy.rightel;

/**
 * proxy client for Rightel service.
 *
 * @author Sevak Gharibian
 */
public interface RightelProxy {
    public RightelProxySubmitChargeRequestResponse submitChargeRequest(String consumer, int amount, int channel);
    public RightelProxyConfirmChargeRequestResponse confirmChargeRequest(String requestId, long trId);
    public RightelProxyInquiryChargeResponse inquiryCharge(long trId);
    public RightelProxyGetAccountBalanceResponse getAccountBalance();
}
