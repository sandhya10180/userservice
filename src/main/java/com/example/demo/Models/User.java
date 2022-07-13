package com.example.demo.Models;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    String firstname;
    String lastname;
    String location;
    String github;
    String image;
    String created_at;


    @OneToOne
    @JoinColumn(name = "is_blocked", nullable = false)
    private Status is_blocked;

    @OneToOne
    @JoinColumn(name = "is_active", nullable = false)
    private Status is_active;

    @OneToOne
    @JoinColumn(name = "is_superuser", nullable = false)
    private Status is_superuser;

    @OneToOne
    @JoinColumn(name = "is_admin", nullable = false)
    private Status is_admin;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Login logins;

}
