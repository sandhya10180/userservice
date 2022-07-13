package com.example.demo.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class VoteView {
    @Id
    @Column(name = "voteview_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteview_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "content_id")
    Content content;



    @ManyToOne
    @JoinColumn(name = "vote_view_status_id")
    StatusVoteView statusVoteView;


}
