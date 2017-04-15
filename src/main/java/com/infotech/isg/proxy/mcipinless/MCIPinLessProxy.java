package com.infotech.isg.proxy.mcipinless;

/**
 * proxy client for MCIPinLess service.
 *
 * @author Sevak Gharibian
 */
public interface MCIPinLessProxy {
    public MCIPinLessProxyGetTokenResponse getToken();
    public MCIPinLessProxyCallSaleProviderResponse callSaleProvider(String token, String consumer, int amount);
    public MCIPinLessProxyExecSaleProviderResponse execSaleProvider(String token, String providerId, String bankCode);
    public MCIPinLessProxyRemainCreditInquiryResponse remainCreditInquiry(String token);
    public MCIPinLessProxyChargeStatusInqueryResponse chargeStatusInquery(String token, String consumer, String providerId, String bankCode);
}
