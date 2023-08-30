package com.example.basecompra.utilities.paypal;

import com.example.basecompra.utilities.paypal.enumerate.PaypalOrderIntent;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PaypalOrderRequest {
    @JsonProperty("intent")
    private PaypalOrderIntent intent;

    @JsonProperty("purchase_units")
    private List<PaypalPurchaseUnitRequest> purchaseUnits;

    @JsonProperty("application_context")
    private PaypalApplicationContext applicationContext;

    public PaypalOrderRequest() {
    }

    public PaypalOrderRequest(PaypalOrderIntent intent, List<PaypalPurchaseUnitRequest> purchaseUnits, PaypalApplicationContext applicationContext) {
        this.intent = intent;
        this.purchaseUnits = purchaseUnits;
        this.applicationContext = applicationContext;
    }

    public PaypalOrderIntent getIntent() {
        return intent;
    }

    public void setIntent(PaypalOrderIntent intent) {
        this.intent = intent;
    }

    public List<PaypalPurchaseUnitRequest> getPurchaseUnits() {
        return purchaseUnits;
    }

    public void setPurchaseUnits(List<PaypalPurchaseUnitRequest> purchaseUnits) {
        this.purchaseUnits = purchaseUnits;
    }

    public PaypalApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(PaypalApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    //    {
//        "intent": "CAPTURE",
//            "purchase_units": [
//        {
//            "description":"Testing Service",
//                "amount": {
//            "breakdown": {
//                "item_total": {
//                    "currency_code": "USD",
//                            "value": "100.0"
//                }
//            },
//            "currency_code": "USD",
//                    "value": "100.0"
//        },
//            "items": [
//            {
//                "sku": "1",
//                    "name": "yada",
//                    "quantity": "1",
//                    "unit_amount": {
//                "currency_code": "USD",
//                        "value": "50.0"
//            },
//                "description":"Service 1"
//            },
//            {
//                "sku": "2",
//                    "name": "yolo",
//                    "quantity": "1",
//                    "unit_amount": {
//                "currency_code": "USD",
//                        "value": "50.0"
//            },
//                "description":"Service 2"
//            }
//            ],
//            "reference_id":"12",
//                "custom_id": "usuarioID"
//        }
//    ],
//        "application_context": {
//        "brand_name":"Proyecto Final Web Avanzada",
//                "landing_page": "BILLING",
//                "return_url": "https://www.google.com",
//                "cancel_url": "https://www.youtube.com"
//    }
//    }
}
