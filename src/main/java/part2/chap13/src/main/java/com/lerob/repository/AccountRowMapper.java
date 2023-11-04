package com.lerob.repository;

import com.lerob.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet row, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(row.getInt("id"));
        account.setName(row.getString("name"));
        account.setAmount(row.getBigDecimal("amount"));
        return account;
    }
}
