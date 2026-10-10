package com.scaler.productservicefeb2025.services;
import com.scaler.productservicefeb2025.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import com.scaler.productservicefeb2025.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public interface ProductService {
    Product getProductById(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();

    Product createProduct(Product product);
    Product replaceProduct(Long productId, Product product) throws ProductNotFoundException;
    void deleteProduct(Long productId) throws ProductNotFoundException;

}
