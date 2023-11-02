package com.lerob.service;

import com.lerob.Exception.NotEnoughMoneyException;
import com.lerob.dto.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() throws NotEnoughMoneyException {
        // Todo: implement process payment logic
        throw new NotEnoughMoneyException();
    }
}

