package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    //private String cid = UUID.randomUUID().toString();

    @NotEmpty
    @NotNull
    @Column(length = 100)
    private String name;

    @NotEmpty
    @NotNull
    @Column(length = 100)
    private String surname;

    @Column(unique = true)
    @Email
    @NotEmpty
    @NotNull
    private String email;

    @NotNull
    private Integer phone;

    @NotNull
    private Boolean status;


}
