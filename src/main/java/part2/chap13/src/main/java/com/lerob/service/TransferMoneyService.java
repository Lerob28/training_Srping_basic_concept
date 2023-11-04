package com.lerob.service;

import com.lerob.model.Account;
import com.lerob.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class TransferMoneyService {
    private final AccountRepository accountRepository;

    @Autowired
    public TransferMoneyService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional  // we can omit this one since it's already present on class level
    public void transferMoney(
        Long senderID,
        Long receiverID,
        BigDecimal amount
    ) {
        Account senderAccount   = accountRepository.findAccountByID(senderID);
        Account receiverAccount = accountRepository.findAccountByID(receiverID);

        BigDecimal senderNewAmount   = senderAccount.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiverAccount.getAmount().add(amount);

        accountRepository.changeAmount(senderID,   senderNewAmount);
        accountRepository.changeAmount(receiverID, receiverNewAmount);

        // uncomment this line to see successfully rollback transaction by spring when runtime error occurs
        // throw new RuntimeException("oups ! something were wrong");
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAllAccount();
    }
}
