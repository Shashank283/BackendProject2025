package com.scaler.productservicefeb2025.InheritanceDemo.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "1")
public class TAs extends User {
    private int noOfHires;

}
