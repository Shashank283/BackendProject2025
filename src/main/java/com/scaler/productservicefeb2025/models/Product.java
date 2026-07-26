package com.scaler.productservicefeb2025.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private String name;
    private float price;
    private String description;
    private Category category;
    private String image;
}