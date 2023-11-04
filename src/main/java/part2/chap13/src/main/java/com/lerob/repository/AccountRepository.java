package com.lerob.repository;


import com.lerob.model.Account;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public class AccountRepository {
    private final JdbcTemplate jdbc;

    public AccountRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Account findAccountByID(long id) {
        String query = "SELECT * FROM account WHERE id= ?";
        return jdbc.queryForObject(query, new AccountRowMapper(), id);
    }

    public void changeAmount(long id, BigDecimal amount) {
        String query = "UPDATE account SET amount= ? WHERE id= ?";
        jdbc.update(query, amount, id);
    }

    public List<Account> findAllAccount() {
        String query = "SELECT * FROM account";
        return jdbc.query(query, new AccountRowMapper());
    }

}
