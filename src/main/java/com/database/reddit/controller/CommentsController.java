package com.database.reddit.controller;

import com.database.reddit.Dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentsController {

    @PostMapping("/{postId}/add")
    public String addComment(@PathVariable Long postId, @RequestBody CommentDto commentDto, Model model){
        model.addAttribute("postData",);
        model.addAttribute("commentDto",new CommentDto());
        return "viewpost";
    }
}
