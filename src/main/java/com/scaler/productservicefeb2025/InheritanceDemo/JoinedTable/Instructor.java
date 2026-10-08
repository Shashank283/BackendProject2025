package com.scaler.productservicefeb2025.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_instructor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User {
    private String specialization;
    private Double ratings;
}
