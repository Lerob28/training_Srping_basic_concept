package com.lerob.repository;


import com.lerob.model.Purchase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbc;

    @Value("${query.insert}")
    String insertQuery;

    private final RowMapper<Purchase> purchaseRowMapper = (row, i) -> {
        Purchase purchase = new Purchase();
        purchase.setId(row.getInt("id"));
        purchase.setProduct(row.getString("product"));
        purchase.setPrice(row.getBigDecimal("price"));
        return purchase;
    };

    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public  void storePurchase(Purchase purchase) {
        jdbc.update(
          this.insertQuery,
          purchase.getId(),
          purchase.getProduct(),
          purchase.getPrice()
        );
    }

    public List<Purchase> findAllPurchase() {
        String query = "SELECT * FROM purchase";
        return  jdbc.query(query, this.purchaseRowMapper);
    }
}
