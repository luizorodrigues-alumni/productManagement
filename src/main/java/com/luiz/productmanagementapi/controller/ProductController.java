package com.luiz.productmanagementapi.controller;

import com.luiz.productmanagementapi.dto.ErrorMessage;
import com.luiz.productmanagementapi.models.Product;
import com.luiz.productmanagementapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // Get all Products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    // Get Product By ID
    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Integer productId){
        try {
            return ResponseEntity.status(200).body(productService.getProductById(productId));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ErrorMessage(e.getMessage()));
        }
    }

    // Create New Product
    @PostMapping("/products")
    public ResponseEntity<?> addNewProduct(@RequestBody Product product){
        return ResponseEntity.status(201).body(productService.createNewProduct(product));
    }

    // Update a product
    @PutMapping("/products/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer productId, @RequestBody Product product){
        try{
            return ResponseEntity.status(200).body(productService.updateProduct(productId, product));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ErrorMessage(e.getMessage()));
        }
    }

    // Delete a product
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        try{
            return ResponseEntity.status(200).body(productService.deleteProduct(productId));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ErrorMessage(e.getMessage()));
        }
    }
}
