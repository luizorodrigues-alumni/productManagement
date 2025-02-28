package com.luiz.productmanagementapi.service;

import com.luiz.productmanagementapi.Exceptions.ProductNotFoundException;
import com.luiz.productmanagementapi.dto.ResponseMessage;
import com.luiz.productmanagementapi.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class ProductService {
    // List simulating an in-memory database of products
    private List<Product> products = new ArrayList<>();

    // Checks if the product exists on the list and return its index
    private int checkProductById(Integer productId){
        return IntStream.range(0, products.size())
                .filter(i -> products.get(i).getId().equals(productId))
                .findFirst()
                .orElse(-1);
    }

    // Gets all products Objects
    public List<Product> getAllProducts(){
        return products;
    }

    // Gets product by id
    public Product getProductById(Integer productId){
        int productIndex = checkProductById(productId);
        if (productIndex == -1){
            throw new ProductNotFoundException("Product Id " + productId + " not found.");
        }
        return products.get(productIndex);
    }

    // Adds new product
    public Product createNewProduct(Product product){
        products.add(product);
        return product;
    }

    // Checks if the id exists and Update the product
    public ResponseMessage updateProduct(Integer productId, Product product){
        int productIndex = checkProductById(productId);
        if (productIndex == -1){
            throw new ProductNotFoundException("Product Id " + productId + " does not exist.");
        }
        products.set(productIndex, product);
        return new ResponseMessage("Product Id " + productId + " updated successfully");
    }

    // Checks if the id exists and Delete the product
    public ResponseMessage deleteProduct(Integer productId){
        int productIndex = checkProductById(productId);
        if (productIndex == -1){
            throw new ProductNotFoundException("Product Id " + productId + " does not exist.");
        }
        products.remove(productIndex);
        return new ResponseMessage("Product Id " + productId + " deleted successfully");
    }
}
