package com.works.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class J_CusAdd {

    @Id
    private Long aid;
    private String address;
    private String city;
    private String title;
    private Long cid;
    private String name;
    private String surname;
    private Long phone;

}
