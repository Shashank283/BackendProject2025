package com.scaler.productservicefeb2025.InheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_Mentors")
public class Mentor extends User {
    private String company;
    private String noOfSessions;
    private Double avgRatings;

}
