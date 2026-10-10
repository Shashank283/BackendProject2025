package com.scaler.productservicefeb2025.controllers;

import com.scaler.productservicefeb2025.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb2025.models.Product;
import com.scaler.productservicefeb2025.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public ProductController(@Qualifier("selfDBProductService") ProductService productService) {
        this.productService = productService;
    }


    //http://localhost:8081/products/1
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
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

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {

        return productService.createProduct(product); //productService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long productId,
                                 @RequestBody Product product) {
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId,
                                  @RequestBody Product product) throws ProductNotFoundException {
        return productService.replaceProduct(productId, product); // We take the produc id and then replace everything except product ID
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        productService.deleteProduct(id);
    }


    // Instead of returning from GlobalExceptionHandler now Exception will return output from here....

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e) {
        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.NOT_FOUND);
    }





}
