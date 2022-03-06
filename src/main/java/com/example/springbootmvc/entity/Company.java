package com.example.springbootmvc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

//bu klassni table bo'lishi kerakligini bildiradi
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {
    //pk bo'lishi kk
    @Id
    //auto increment va sequence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //ustun unga bo'lgan xamma xususiyatlar
    @Column(nullable = false, unique = true)
    private String name;

    //bitta ortiqcha malumot saqlash un table yaratadi
//    @OneToMany
//    private List<Department> departmentList;

}
