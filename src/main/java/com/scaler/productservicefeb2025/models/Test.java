package com.scaler.productservicefeb2025.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tests")
public class Test extends BaseModel {
    private String name;
    private String description;


}
