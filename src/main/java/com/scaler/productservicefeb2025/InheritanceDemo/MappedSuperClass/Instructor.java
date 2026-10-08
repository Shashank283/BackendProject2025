package com.scaler.productservicefeb2025.InheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_Instructors")
public class Instructor extends User{
    private String specialization;
    private Double ratings;
}
