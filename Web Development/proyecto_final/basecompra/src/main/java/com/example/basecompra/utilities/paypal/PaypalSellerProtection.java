package com.example.basecompra.utilities.paypal;

import com.example.basecompra.utilities.paypal.enumerate.PaypalDisputeCategory;
import com.example.basecompra.utilities.paypal.enumerate.PaypalSellerProtectionStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PaypalSellerProtection {
    @JsonProperty("status")
    private PaypalSellerProtectionStatus status;

    @JsonProperty("dispute_categories")
    private List<PaypalDisputeCategory> disputeCategories;

    public PaypalSellerProtectionStatus getStatus() {
        return status;
    }

    public void setStatus(PaypalSellerProtectionStatus status) {
        this.status = status;
    }

    public List<PaypalDisputeCategory> getDisputeCategories() {
        return disputeCategories;
    }

    public void setDisputeCategories(List<PaypalDisputeCategory> disputeCategories) {
        this.disputeCategories = disputeCategories;
    }
}
