package com.scaler.productservicefeb2025.services;

import com.scaler.productservicefeb2025.Repositories.CategoryRepository;
import com.scaler.productservicefeb2025.Repositories.ProductRepository;
import com.scaler.productservicefeb2025.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb2025.models.Category;
import com.scaler.productservicefeb2025.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfDBProductService")
//@Primary
public class SelfDBProductService implements ProductService {

    public ProductRepository productRepository;
    public CategoryRepository categoryRepository;
    public SelfDBProductService(ProductRepository productRepository ,  CategoryRepository categoryRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {






        // IF WE JUST RETURN THE SAVE() FN WE GET ERROR ON BELOW PERSISTENCE THAT CATEGORY INSTANCE IS NOT CREATED
        // TransientPropertyValueException: Persistent instance of 'com.scaler.productservicefeb2025.models.Product' references an unsaved
        // transient instance of 'com.scaler.productservicefeb2025.models.Category' (persist the transient instance before flushing


        Category category = product.getCategory();

        Optional<Category>   optionalCategory = categoryRepository.findByName( category.getName());

        if(optionalCategory.isEmpty()) {
           category= categoryRepository.save(category);
        }
        else {
           category = optionalCategory.get();
        }

        product.setCategory(category);



        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()) {
            throw  new ProductNotFoundException("Product with id " + productId + " not found");
        }

        Product productFromDB = optionalProduct.get();
        productFromDB.setTitle(product.getTitle());
        productFromDB.setDescription(product.getDescription());
        productFromDB.setPrice(product.getPrice());
        productFromDB.setImageUrl(product.getImageUrl());

        // FOR CATEGORY WE NEED TO CHECK WHETHER CATEGORY EXISTS OR NOT

        Category category = product.getCategory();

      Optional<Category> categoryName = categoryRepository.findByName( category.getName());

        if (category.getId() == null) {
            category = categoryRepository.save(category);
        }
        productFromDB.setCategory(category);


        return productRepository.save(productFromDB);
    }

    @Override
    public void deleteProduct(Long productId) throws ProductNotFoundException {
        if (productRepository.findById(productId).isEmpty()) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        productRepository.deleteById(productId);
    }

}
