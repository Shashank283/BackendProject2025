package com.scaler.productservicefeb2025.InheritanceDemo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    private String company;
    private String noOfSessions;
    private Double avgRatings;

}
