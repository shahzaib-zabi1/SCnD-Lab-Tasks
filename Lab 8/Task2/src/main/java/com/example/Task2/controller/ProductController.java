package com.example.Task2.controller;

import com.example.Task2.model.Product;
import com.example.Task2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PostMapping("/bulk")
    public List<Product> createMultipleProducts(@RequestBody List<Product> products) {
        return productService.createMultipleProducts(products);
    }

    @PostMapping("/{id}/clone")
    public Product cloneProduct(@PathVariable Long id, @RequestParam String color) {
        return productService.cloneProduct(id, color);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
