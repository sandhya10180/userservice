package com.example.demo.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Resolution {
    @Id
    @Column(name = "aid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    @ManyToOne
    @JoinColumn(name = "question_id")
    Question question;

    @OneToOne
    @JoinColumn(name = "content_id")
    Content content;
}
