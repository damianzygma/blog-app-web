package com.damianzygma.blogappweb.controller;

import com.damianzygma.blogappweb.dto.CommentDto;
import com.damianzygma.blogappweb.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // handler method to handle comment
    @PostMapping("/{postUrl}/comments")
    public String createComment(@PathVariable("postUrl") String postUrl,
                                @ModelAttribute("comment") CommentDto commentDto,
                                Model model){

        commentService.creatComment(postUrl, commentDto);
        return "redirect:/post/" + postUrl;
    }

}
