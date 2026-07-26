package com.scaler.productservicefeb2025.controllers;

import com.scaler.productservicefeb2025.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb2025.models.Product;
import com.scaler.productservicefeb2025.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") int id) throws ProductNotFoundException {
      /*  ResponseEntity<Product> responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(
                    productService.getProductById(id),
                    HttpStatus.OK);

        }
        catch (ProductNotFoundException e) {
            responseEntity = new ResponseEntity<>(
                    (HttpHeaders) null,
                    (HttpStatusCode) HttpStatus.BAD_GATEWAY);
        }
        return responseEntity;
*/

        return productService.getProductById(id);

    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // Instead of returning from GlobalExceptionHandler now Exception will return output from here....

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e) {
        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.NOT_FOUND);
    }





}
