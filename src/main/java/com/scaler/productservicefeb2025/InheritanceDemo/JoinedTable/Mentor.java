package com.scaler.productservicefeb2025.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Getter
@Setter
@Entity(name = "jt_Mentors")
@PrimaryKeyJoinColumn(name= "user_id")
public class Mentor extends User {
    private String company;
    private String noOfSessions;
    private Double avgRatings;

}
