package com.lerob.controller;


import com.lerob.model.Payment;
import com.lerob.proxy.PaymentProxy;
import com.lerob.proxy.WebClientPaymentProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RestController
public class PaymentController {
    private final PaymentProxy paymentProxy;
    private final WebClientPaymentProxy webClientPaymentProxy;

    public PaymentController(
        PaymentProxy paymentProxy,
        WebClientPaymentProxy webClientPaymentProxy
    ) {
        this.paymentProxy = paymentProxy;
        this.webClientPaymentProxy = webClientPaymentProxy;
    }


    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentProxy.createPayment(payment);
    }

    @PostMapping("/payment2")
    public Mono<Payment> createPayment2(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        return webClientPaymentProxy.createPayment(requestId, payment);
    }
}
