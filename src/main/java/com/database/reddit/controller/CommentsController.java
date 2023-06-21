package com.database.reddit.controller;

import com.database.reddit.Dto.CommentDto;
import com.database.reddit.service.CommentService;
import com.database.reddit.service.PostsService;
import com.database.reddit.service.interfaces.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentsController {
    private final FileService fileService;
    private final PostsService postsService;
    private final CommentService commentService;

    // r/{communityName}/comments/{postId}/add
    @PostMapping("/{postId}/add")
    public String addComment(@PathVariable Long postId, @ModelAttribute CommentDto commentDto, Model model) {
        commentService.addComment(postId, commentDto);
        model.addAttribute("postData", postsService.getPost(postId));
        model.addAttribute("commentDto", new CommentDto());
        return "viewpost";
    }

    @PostMapping("/{postId}/reply/{commentId}")
    public String addReply(@PathVariable Long commentId,
                           @ModelAttribute CommentDto commentDto,
                           @PathVariable Long postId, Model model) {

        commentService.addReply(commentId, commentDto);
        model.addAttribute("postData", postsService.getPost(postId));
        model.addAttribute("commentDto", new CommentDto());
        return "viewpost";
    }
}
