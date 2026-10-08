package com.scaler.productservicefeb2025.InheritanceDemo.JoinedTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_Users")

@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
