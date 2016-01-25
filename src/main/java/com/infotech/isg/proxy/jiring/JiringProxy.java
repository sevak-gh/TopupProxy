package com.infotech.isg.proxy.jiring;

/**
 * proxy client for Jiring service.
 *
 * @author Sevak Gharibian
 */
public interface JiringProxy {
    public TCSResponse salesRequest(String consumer, int amount, String brandId, String sender);
    public TCSResponse salesRequestExec(String token, boolean checkOnly);
    public TCSResponse balance();
}
