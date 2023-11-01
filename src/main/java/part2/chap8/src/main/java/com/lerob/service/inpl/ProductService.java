package com.lerob.service.inpl;

import com.lerob.model.Product;
import com.lerob.service.I_ProductSevice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements I_ProductSevice {
    private List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}
