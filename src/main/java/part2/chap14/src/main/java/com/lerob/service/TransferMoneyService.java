package com.lerob.service;

import com.lerob.exception.AccountNotFoundException;
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

    public void transferMoney(
        Long senderID,
        Long receiverID,
        BigDecimal amount
    ) {
        Account senderAccount   = accountRepository.findById(senderID).orElseThrow(AccountNotFoundException::new);
        Account receiverAccount = accountRepository.findById(receiverID).orElseThrow(AccountNotFoundException::new);

        BigDecimal senderNewAmount   = senderAccount.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiverAccount.getAmount().add(amount);

        accountRepository.changeAmount(senderID,   senderNewAmount);
        accountRepository.changeAmount(receiverID, receiverNewAmount);
    }

    public Iterable<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String accountName) {
        return accountRepository.findAccountByName(accountName);
    }
}
