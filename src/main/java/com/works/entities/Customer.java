package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Customer extends Base {

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
    private Long phone;

    @NotNull
    private Boolean status;


    @PrePersist
    public void prePersist() {
        System.out.println("customer prePersist");
    }

    @PostPersist
    public void postPersist() {
        System.out.println("customer postPersist : " + this.cid);
    }


    @PostLoad
    public void postLoad() {
        System.out.println("customer postLoad");
    }

}
