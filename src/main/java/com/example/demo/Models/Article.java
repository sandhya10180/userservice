package com.example.demo.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Article {
    @Id
    @Column(name = "artical_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artical_id;

    @OneToOne
    @JoinColumn(name = "content_id")
    Content content;

}
