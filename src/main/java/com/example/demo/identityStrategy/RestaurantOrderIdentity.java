package com.example.demo.identityStrategy;


import javax.persistence.*;

@Entity
public class RestaurantOrderIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String test;
}
