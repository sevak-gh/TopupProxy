package com.infotech.isg.proxy.vopay;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * representing vopay package_info object.
 *
 * @author Sevak Gharibian
 */
public class VopayProxyPackageInfo {

    private String name;
    private BigDecimal baseCost;
    private BigDecimal transactionFee;
    private BigDecimal totalCost;
    private BigDecimal proposedSellingPrice;
    private String currency;

    @JsonProperty("Package")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("BaseCost")
    public BigDecimal getBseCost() {
        return baseCost;
    }

    public void setBaseCost(BigDecimal baseCost) {
        this.baseCost = baseCost;
    }

    @JsonProperty("TransactionFee")
    public BigDecimal getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(BigDecimal transactionFee) {
        this.transactionFee = transactionFee;
    }

    @JsonProperty("TotalCost")
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @JsonProperty("ProposedSellingPrice")
    public BigDecimal getProposedSellingPrice() {
        return proposedSellingPrice;
    }

    public void setProposedSellingPrice(BigDecimal proposedSellingPrice) {
        this.proposedSellingPrice = proposedSellingPrice;
    }

    @JsonProperty("Currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return String.format("PackageInfo[name: %s, baseCost: %s, transactionFee: %s, totalCost: %s, proposedSellingPrice: %s, currency: %s]", 
                              name, String.valueOf(baseCost), String.valueOf(transactionFee), 
                              String.valueOf(totalCost), String.valueOf(proposedSellingPrice), currency);
    }
}
