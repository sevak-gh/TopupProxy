package com.infotech.isg.proxy.mtn;

/**
 * proxy client for MTN service.
 *
 * @author Sevak Gharibian
 */
public interface MTNProxy {
    public MTNProxyResponse recharge(String consumer, int amount, long trId);
    public MTNProxyResponse billPayment(String consumer, int amount, long trId);
    public MTNProxyResponse bulkTransfer(String consumer, int amount, long trId);
    public MTNProxyResponse wow(String consumer, int amount, long trId);
    public MTNProxyResponse postPaidWimax(String consumer, int amount, long trId);
    public MTNProxyResponse prePaidWimax(String consumer, int amount, long trId);
    public MTNProxyResponse gprs(String consumer, int amount, long trId);
}
