package com.scaler.productservicefeb2025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
    private String name;
    private float price;
    private String description;
    private String image;
    @ManyToOne   // outer to inner --> Product to Category
    private Category category;



    
}