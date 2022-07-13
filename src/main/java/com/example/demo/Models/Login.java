package com.example.demo.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Login {
    @Id
    @Column(name = "userid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    private String email;
    private String password;


}
