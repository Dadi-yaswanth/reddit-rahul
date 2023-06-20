package com.database.reddit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "reply_tbl")
@Getter
@Setter
@NoArgsConstructor
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    private String content;

    @Column(name = "replied_at")
    @CreationTimestamp
    private Timestamp repliedAt;

    @Column(name = "upvote")
    private long upvote;

    @Column(name = "down_vote")
    private long downVote;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = Comment.class)
    @JoinColumn(name="comment_id")
    private Comment comment;
}
