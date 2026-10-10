package com.scaler.productservicefeb2025.Repositories;

import com.scaler.productservicefeb2025.models.Category;
import com.scaler.productservicefeb2025.models.Product;
import com.scaler.productservicefeb2025.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long productId);

    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);

    void deleteById(Long productId);

  Optional<Product> findByTitleContains(String str);
// Select * from products where title like '%str%'
   Optional<Product> findByCategory(Category category);

   Optional<Product> findByCategory_Id(Long categoryId);

   // CUSTOM QUERIES
    // select title, price from products table where id =1;

    //HQL - HIBERNATE QUERY LANGUAGE // BASED ON MODELS
//
//    @Query("select p.title as title, p.price as price from Product p where p.title = :title and p.price = :price")
//    List<ProductWithTitleAndPrice> getProductTitleAndPrices( String title, Double price);



    // SQL -> Native SQL Query
    @Query( value = "select p.title, p.price from products p where p.title = :title and p.price = :price")
    List<ProductWithTitleAndPrice> getProductTitleAndPricesSQL(String title, Double price);


}
