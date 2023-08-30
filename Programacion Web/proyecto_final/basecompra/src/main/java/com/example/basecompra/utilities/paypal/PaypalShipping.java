package com.example.basecompra.utilities.paypal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaypalShipping {
    @JsonProperty("name")
    private PaypalShippingName name;

    @JsonProperty("address")
    private PaypalAddress paypalShippingAddress;
}
