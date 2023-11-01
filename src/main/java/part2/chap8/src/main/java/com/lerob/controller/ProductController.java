package com.lerob.controller;


import com.lerob.model.Product;
import com.lerob.service.I_ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/products")
public class ProductController {
    private final I_ProductSevice productService;

    @Autowired
    public ProductController(I_ProductSevice productService) {
        this.productService = productService;
    }

    @GetMapping
    public String viewProduct(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping
    public String addProduct(
        //@RequestParam String name,
        //@RequestParam Double price,
        Product product,
        Model model
    ) {
        /*Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);
        */
        productService.addProduct(product);
        var products = productService.findAll();
        
        model.addAttribute("products", products);

        return "products";
    }


}
