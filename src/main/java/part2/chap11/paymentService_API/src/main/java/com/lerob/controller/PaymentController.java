package com.lerob.controller;


import com.lerob.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;


@RestController
public class PaymentController {
    private static final Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(
        @RequestHeader String requestId,
        @RequestBody Payment payment
    ) {
        logger.info("Received request with ID: "+requestId+" payment amount: "+payment.getAmount());
        payment.setId(UUID.randomUUID().toString());

        return ResponseEntity
            .status(201)
            .header("requestID", requestId)
            .body(payment);
    }
}
