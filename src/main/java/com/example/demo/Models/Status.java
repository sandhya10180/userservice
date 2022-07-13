package com.example.demo.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Status {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String Status;

}
