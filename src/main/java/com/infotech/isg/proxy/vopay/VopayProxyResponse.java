package com.infotech.isg.proxy.vopay;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * representing vopay abstract response object.
 *
 * @author Sevak Gharibian
 */
public abstract class VopayProxyResponse {

    protected Boolean success;
    protected String errorMessage;    

    @JsonProperty("Success")
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("ErrorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
