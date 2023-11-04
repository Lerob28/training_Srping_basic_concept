package com.lerob.repository;

import com.lerob.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;


public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("SELECT * FROM account WHERE name= :accountName")
    List<Account> findAccountByName(String accountName);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :accountID")
    void changeAmount(long accountID, BigDecimal amount);

}
