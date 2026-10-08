package com.scaler.productservicefeb2025.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_Users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
