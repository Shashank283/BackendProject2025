package com.scaler.productservicefeb2025.services;

import com.scaler.productservicefeb2025.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb2025.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class SelfDBProductService implements ProductService {
    @Override
    public Product getProductById(int productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
