package com.example.demo.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class StatusVoteView {
    @Id
    @Column(name = "status_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long status_id;

   String voteview_type;
}
