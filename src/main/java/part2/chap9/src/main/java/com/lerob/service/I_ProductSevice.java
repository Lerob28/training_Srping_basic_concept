package com.lerob.service;

import com.lerob.model.Product;

import java.util.List;

public interface I_ProductSevice {
    void addProduct(Product product);
    List<Product> findAll();
}
