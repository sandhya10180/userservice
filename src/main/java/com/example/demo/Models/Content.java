package com.example.demo.Models;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Content {
    @Id
    @Column(name = "content_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long content_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    private Date created_at;
    private String content_file;
    private  String title;

    @OneToOne
    @JoinColumn(name = "is_disabled", nullable = false)
    private Status status1;

    @OneToOne
    @JoinColumn(name = "is_reported", nullable = false)
    private Status status2;
}
