package com.scaler.productservicefeb2025.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "category")
    List<Product> products;
}
