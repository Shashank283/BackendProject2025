package com.scaler.productservicefeb2025.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_tas")
public class TAs extends User {
    private int noOfHires;

}
