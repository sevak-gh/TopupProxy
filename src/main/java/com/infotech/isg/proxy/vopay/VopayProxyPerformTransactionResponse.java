package com.infotech.isg.proxy.vopay;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * representing vopay perform_transaction response object.
 *
 * @author Sevak Gharibian
 */
public class VopayProxyPerformTransactionResponse extends VopayProxyResponse {

    private String recipientPhoneNumber;
    private String country;
    private String operator;
    private String packageName;
    private BigDecimal price;
    private BigDecimal wholesale;
    private String currency;
    private String timestamp;
    private Integer transactionId;
    private String confirmationNumber;
    private Boolean emailSent;
    private Boolean smsSent;

    @JsonProperty("RecipientPhoneNumber")
    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public void setRecipientPhoneNumber(String recipientPhoneNumber) {
        this.recipientPhoneNumber= recipientPhoneNumber;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("Operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @JsonProperty("Package")
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @JsonProperty("Price")
    public BigDecimal getPrice() {
        return price;
    }
        
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @JsonProperty("Wholesale")
    public BigDecimal getWholesale() {
        return wholesale;
    }
        
    public void setWholesale(BigDecimal wholesale) {
        this.wholesale = wholesale;
    }

    @JsonProperty("Currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency= currency;
    }

    @JsonProperty("Timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("TransactionID")
    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    @JsonProperty("ConfirmationNumber")
    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    @JsonProperty("EmailSent")
    public Boolean getEmailSent() {
        return emailSent;
    }

    public void setEmailSent(Boolean emailSent) {
        this.emailSent = emailSent;
    }

    @JsonProperty("SMSSent")
    public Boolean getSmsSent() {
        return smsSent;
    }

    public void setSmsSent(Boolean smsSent) {
        this.smsSent = smsSent;
    }

    @Override
    public String toString() {
        return String.format("PerformTransactionResponse[success:%s, errorMessage: %s, recipientPhoneNumber: %s, country: %s, " +  
                             "operator: %s, package: %s, price; %s, timestamp: %s, transactionId: %s, confirmationNumber: %s]", 
                             String.valueOf(success), errorMessage, recipientPhoneNumber, country,
                             operator, packageName, String.valueOf(price), timestamp, String.valueOf(transactionId),
                             confirmationNumber);
    }
}
