package com.scaler.productservicefeb2025.exceptions;

// This package manages custom exceptions

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
