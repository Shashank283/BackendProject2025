package com.scaler.productservicefeb2025.models;

import jakarta.persistence.*;
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
    @ManyToOne(cascade = CascadeType.REMOVE)   // outer to inner --> Product to Category
    @JoinColumn
    private Category category;



    
}