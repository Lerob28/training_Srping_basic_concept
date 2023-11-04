package com.lerob.controller;

import com.lerob.model.Account;
import com.lerob.model.TransferRequest;
import com.lerob.service.TransferMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private final TransferMoneyService transferMoneyService;

    @Autowired
    public AccountController(TransferMoneyService transferMoneyService) {
        this.transferMoneyService = transferMoneyService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
        @RequestBody TransferRequest request
    ) {
        transferMoneyService.transferMoney(
            request.getSenderID(),
            request.getReceiverID(),
            request.getAmount()
        );
    }

    @GetMapping("/account")
    public Iterable<Account> getAllAccount(
        @RequestParam(required = false) String name
    ) {
        return name == null
            ? transferMoneyService.getAllAccount()
            : transferMoneyService.findAccountsByName(name);
    }
}
