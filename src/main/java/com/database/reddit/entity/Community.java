package com.database.reddit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "community")
@Getter
@Setter
public class Community {

    @Column(name = "community_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "community_name")
    private String community_name;

    @Column(name = "creation_date")
    @CreationTimestamp
    private Timestamp creation_date;

    @Column(name = "about")
    private String about;

    @Column(name = "wiki")
    private String wiki;

    @Column(
            name = "is_private",
            columnDefinition = "BOOLEAN DEFAULT FALSE"
    )
    private boolean is_private;

    @Column(name = "is_restrict",
            columnDefinition = "BOOLEAN DEFAULT FALSE"
    )
    private boolean is_restrict;

    @ManyToOne
    @JoinColumn(name = "owner_id",nullable = false)
    private User owner;

    @OneToMany(mappedBy ="community")
    private List<Post> communityPosts;

    @ManyToMany
    @JoinTable(
            name = "community_people",
            joinColumns = {@JoinColumn(name = "community_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
   private Set<User> communityPeople;

    @ManyToMany
    @JoinTable(
            name = "community_moderators",
            joinColumns = {@JoinColumn(name = "community_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> communityModerators;

}
