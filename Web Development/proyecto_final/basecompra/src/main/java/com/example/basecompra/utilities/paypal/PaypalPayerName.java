package com.example.basecompra.utilities.paypal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaypalPayerName {
    @JsonProperty("given_name")
    private String givenName;

    @JsonProperty("surname")
    private String surname;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
