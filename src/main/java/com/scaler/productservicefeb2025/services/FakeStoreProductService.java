package com.scaler.productservicefeb2025.services;

import com.scaler.productservicefeb2025.dtos.FakeStoreProductDto;
import com.scaler.productservicefeb2025.exceptions.ProductNotFoundException;
import com.scaler.productservicefeb2025.models.Category;
import com.scaler.productservicefeb2025.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;


    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;

    }

    public Product getProductById(Long productId) throws ProductNotFoundException {
       /*
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/"+productId, FakeStoreProductDto.class);

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
        */

        //testing custom exception class below
       /* throw  new ProductNotFoundException("Not supported yet.");*/

        // Implementing with exception

        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/"+productId,
                        FakeStoreProductDto.class);

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product not found for id: "+productId);
        }
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);


    }

    // Implementing list of all products for all products
    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);



        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto1 : fakeStoreProductDto){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto1));

        }

        return products;


    }
}
