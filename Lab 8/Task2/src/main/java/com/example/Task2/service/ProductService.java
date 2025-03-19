package com.example.Task2.service;

import com.example.Task2.model.Product;
import com.example.Task2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    public List<Product> createMultipleProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Product cloneProduct(Long productId, String newColor) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isPresent()) {
            Product clonedProduct = existingProduct.get().clone();
            clonedProduct.setId(null); // Reset ID for new entry
            clonedProduct.setColor(newColor); // Set new color
            return productRepository.save(clonedProduct);
        } else {
            throw new RuntimeException("Product not found with ID: " + productId);
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
