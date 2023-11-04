package com.lerob.controller;

import com.lerob.model.Account;
import com.lerob.model.TransferRequest;
import com.lerob.service.TransferMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AccountController {
    private final TransferMoneyService transfertMoneyService;

    @Autowired
    public AccountController(TransferMoneyService transfertMoneyService) {
        this.transfertMoneyService = transfertMoneyService;
    }


    @PostMapping("/transfer")
    public void storePurchase(@RequestBody TransferRequest request) {
        transfertMoneyService.transferMoney(
            request.getSenderID(),
            request.getReceiverID(),
            request.getAmount()
        );
    }

    @GetMapping("/account")
    public List<Account> getAllPurchase() {
        return transfertMoneyService.getAllAccount();
    }
}
