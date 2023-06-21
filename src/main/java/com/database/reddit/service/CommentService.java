package com.database.reddit.service;

import com.database.reddit.Dto.CommentDto;
import com.database.reddit.entity.Comment;
import com.database.reddit.entity.Post;
import com.database.reddit.entity.Reply;
import com.database.reddit.entity.User;
import com.database.reddit.repository.CommentRepository;
import com.database.reddit.repository.PostRepository;
import com.database.reddit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public void addComment(Long postId, CommentDto commentDto){
        //find user using authorize later
        User user = userRepository.findById(1L).orElseThrow(); //have to replace it with authorization user
        Post post = postRepository.findById(postId).orElseThrow();

        List<Comment> postComments = post.getComments();
        Comment comment = new Comment();
        comment.setContent(commentDto.getComment());
        comment.setUser(user);

        postComments.add(comment);
        post.setComments(postComments);
        postRepository.save(post);
        System.out.println("yoo");
    }

    public void addReply(Long commentId,CommentDto commentDto){
        User user = userRepository.findById(1L).orElseThrow(); //have to replace it with authorization user
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        List<Reply> commentReplies = comment.getReplyComments();

        Reply reply = new Reply();
        reply.setContent(commentDto.getComment());
        reply.setUser(user);
        commentReplies.add(reply);
        comment.setReplyComments(commentReplies);
        commentRepository.save(comment);
    }
}
