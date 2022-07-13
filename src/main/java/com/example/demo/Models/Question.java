package com.example.demo.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Question {
    @Id
    @Column(name = "qid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qid;

    @OneToOne
    @JoinColumn(name = "content_id")
    Content content;
}
