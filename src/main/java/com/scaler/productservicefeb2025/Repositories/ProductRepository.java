package com.scaler.productservicefeb2025.Repositories;

import com.scaler.productservicefeb2025.models.Category;
import com.scaler.productservicefeb2025.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long productId);

    @Override
    List<Product> findAll();

  // Optional<Product> findByTitleContains(String str);

 //  Optional<Product> findByCategory(Category category);

 //  Optional<Product> findByCategory_Id(Long categoryId);
}
