package com.infotech.isg.proxy.vopay;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * representing vopay available_packages response object.
 *
 * @author Sevak Gharibian
 */
public class VopayProxyAvailablePackagesResponse extends VopayProxyResponse {

    private String phoneNumber;
    private String country;
    private String operator;
    private List<VopayProxyPackageInfo> packages = new ArrayList<VopayProxyPackageInfo>();

    @JsonProperty("PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber= phoneNumber;
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

    @JsonProperty("PackageList")
    public List<VopayProxyPackageInfo> getPackages() {
        return packages;
    }

    public void setPackages(List<VopayProxyPackageInfo> packages) {
        this.packages = packages;
    }

    @Override
    public String toString() {
        return String.format("AvailablePackagesResponse[success:%s, errorMessage: %s, phoneNumber: %s, country: %s, operator: %s, packages: %s]", 
                             String.valueOf(success), errorMessage, phoneNumber, country, operator, String.valueOf(packages));
    }
}
