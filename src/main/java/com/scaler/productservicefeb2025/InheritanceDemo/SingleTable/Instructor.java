package com.scaler.productservicefeb2025.InheritanceDemo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "3")
public class Instructor extends User {
    private String specialization;
    private Double ratings;
}
