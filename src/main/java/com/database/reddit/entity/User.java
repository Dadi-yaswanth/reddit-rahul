package com.database.reddit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "_user")
@Entity
public class User {

    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "display_name")
    private String display_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "up_votes")
    private Long up_votes;

    @Column(name = "down_votes")
    private Long down_votes;

    @Column(name = "karma")
    private Long karma;

    @OneToMany(mappedBy = "user")
    private Set<Post> userPosts;

    @OneToMany(mappedBy = "owner")
    private Set<Community> ownedCommunities;

    @ManyToMany(mappedBy = "communityPeople")
    private Set<Community> joinedCommunities;

    @ManyToMany(mappedBy = "communityModerators")
    private Set<Community> moderationAuthorities;
}
