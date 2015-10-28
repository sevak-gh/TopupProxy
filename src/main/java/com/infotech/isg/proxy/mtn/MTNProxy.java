package com.infotech.isg.proxy.mtn;

/**
 * proxy client for MTN service.
 *
 * @author Sevak Gharibian
 */
public interface MTNProxy {
    public MTNProxyResponse recharge(String consumer, int amount, long trId, String channel);
    public MTNProxyResponse billPayment(String consumer, int amount, long trId, String channel);
    public MTNProxyResponse bulkTransfer(String consumer, int amount, long trId, String channel);
    public MTNProxyResponse wow(String consumer, int amount, long trId, String channel);
    public MTNProxyResponse postPaidWimax(String consumer, int amount, long trId, String channel);
    public MTNProxyResponse prePaidWimax(String consumer, int amount, long trId, String channel);
    public MTNProxyResponse gprs(String consumer, int amount, long trId, String channel);
    public MTNProxyResponse gprsCombo(String consumer, int amount, long trId, int profileId, String channel);
    public MTNProxyResponse verify(long trId);
    public MTNProxyResponse getBalance();
}
