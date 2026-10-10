package com.scaler.productservicefeb2025.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
    private String title;
    private Double price;
    private String description;
    private String imageUrl;
    @ManyToOne   // outer to inner --> Product to Category


    private Category category;



    
}