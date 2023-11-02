package com.lerob.controller;


import com.lerob.Exception.NotEnoughMoneyException;
import com.lerob.dto.PaymentError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionPaymentAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<PaymentError> exceptionNotEnoughMoneyHandler() {
        PaymentError paymentError = new PaymentError();
        paymentError.setMessage("Not enough money to make the payment2");

        return  ResponseEntity
                .badRequest()
                .body(paymentError);
    }
}
