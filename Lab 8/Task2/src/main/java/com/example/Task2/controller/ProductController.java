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

    // ✅ Create a single product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // ✅ Create multiple products at once
    @PostMapping("/bulk")
    public List<Product> createMultipleProducts(@RequestBody List<Product> products) {
        return productService.createMultipleProducts(products);
    }

    // ✅ Clone a product with a new color
    @PostMapping("/{id}/clone")
    public Product cloneProduct(@PathVariable Long id, @RequestParam String color) {
        return productService.cloneProduct(id, color);
    }

    // ✅ Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
