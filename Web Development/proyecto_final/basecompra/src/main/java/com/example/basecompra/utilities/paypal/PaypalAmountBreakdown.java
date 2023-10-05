package com.example.basecompra.utilities.paypal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaypalAmountBreakdown {
    @JsonProperty("item_total")
    private PaypalAmount itemTotal;

    public PaypalAmountBreakdown(String currencyCode, String value) {
        this.itemTotal = new PaypalAmount(currencyCode, value);
    }

    public PaypalAmount getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(PaypalAmount itemTotal) {
        this.itemTotal = itemTotal;
    }
}
