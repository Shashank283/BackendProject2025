package com.scaler.productservicefeb2025.models;

import jakarta.persistence.Entity;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel{
    private String name;
}
