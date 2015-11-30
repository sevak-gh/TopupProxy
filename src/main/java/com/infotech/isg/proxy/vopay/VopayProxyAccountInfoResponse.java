package com.infotech.isg.proxy.vopay;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * representing vopay account_info response object.
 *
 * @author Sevak Gharibian
 */
public class VopayProxyAccountInfoResponse extends VopayProxyResponse {

    private String accountId;
    private BigDecimal accountBalance;
    private String accountCurrency;
    private List<VopayProxyAgentInfo> agents = new ArrayList<VopayProxyAgentInfo>();

    @JsonProperty("AccountID")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId= accountId;
    }

    @JsonProperty("AccountBalance")
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
        
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    @JsonProperty("AccountCurrency")
    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    @JsonProperty("Agents")
    public List<VopayProxyAgentInfo> getAgents() {
        return agents;
    }

    public void setAgents(List<VopayProxyAgentInfo> agents) {
        this.agents = agents;
    }

    @Override
    public String toString() {
        return String.format("AccountInfoResponse[success:%s, errorMessage: %s, accountId: %s, accountBalance; %s, accountCurrency: %s, agents: %s]", 
                             String.valueOf(success), errorMessage, accountId, String.valueOf(accountBalance), accountCurrency, String.valueOf(agents));
    }
}
