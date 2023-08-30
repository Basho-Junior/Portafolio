package com.example.basecompra.utilities.paypal.Webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaypalWebhookVerifyResponse {
    @JsonProperty("verification_status")
    private PaypalWebhookVerifyResponseStatus verificationStatus;

    public PaypalWebhookVerifyResponseStatus getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(PaypalWebhookVerifyResponseStatus verificationStatus) {
        this.verificationStatus = verificationStatus;
    }
}
