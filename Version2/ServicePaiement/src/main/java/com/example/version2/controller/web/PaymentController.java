package com.example.version2.controller.web;

import com.example.version2.dto.CreatePayment;
import com.example.version2.dto.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPayment(@RequestBody CreatePayment createPayment) throws StripeException {
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(15*100L)
                    .setCurrency("eur")
                    .setCustomer(createPayment.getCustomerId())
                    .build();

            // Create a PaymentIntent with the order amount and currency
            PaymentIntent paymentIntent = PaymentIntent.create(params);

            return new CreatePaymentResponse(paymentIntent.getClientSecret());
    }
}
