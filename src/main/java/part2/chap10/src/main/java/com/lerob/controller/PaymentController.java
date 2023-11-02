package com.lerob.controller;

import com.lerob.Exception.NotEnoughMoneyException;
import com.lerob.dto.PaymentDetails;
import com.lerob.dto.PaymentError;
import com.lerob.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController
public class PaymentController {
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                .status(HttpStatusCode.valueOf(200))
                .body(paymentDetails);
        } catch (NotEnoughMoneyException err) {
            PaymentError paymentError = new PaymentError();
            paymentError.setMessage("Not enough money to make the payment");
            return  ResponseEntity
                .badRequest()
                .body(paymentError);
        }
    }

    @PostMapping("/payment2")
    public ResponseEntity<PaymentDetails> makePayment2() {
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                .status(HttpStatusCode.valueOf(200))
                .body(paymentDetails);
    }

    @PostMapping("/payment3")
    public ResponseEntity<PaymentDetails> makePayment3(@RequestBody PaymentDetails paymentDetails) {
        logger.info("Received payment " + paymentDetails.getAmount());
            return ResponseEntity
                .status(HttpStatusCode.valueOf(200))
                .body(paymentDetails);
    }
}
