package com.scaler.productservicefeb2025.InheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_TAs")
public class TAs extends User {
    private int noOfHires;

}
