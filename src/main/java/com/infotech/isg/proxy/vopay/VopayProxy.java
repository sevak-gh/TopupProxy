package com.infotech.isg.proxy.vopay;

/**
 * proxy client for vopay service.
 *
 * @author Sevak Gharibian
 */
public interface VopayProxy {
    public VopayProxyAccountInfoResponse accountInfo();
    public VopayProxyAvailablePackagesResponse availablePackages(String phoneNumber);
    public VopayProxyPerformTransactionResponse performTransaction(String recipientPhoneNumber,
                                                                   String packageName,
                                                                   String senderName,
                                                                   String senderPhoneNumber,
                                                                   String senderEmail,
                                                                   String senderMessage);
}
