package com.example.demo.Models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
    @Id
    @Column(name = "comment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    String comment;
    @ManyToOne
    User user;

    @ManyToOne
    Content content;

}
