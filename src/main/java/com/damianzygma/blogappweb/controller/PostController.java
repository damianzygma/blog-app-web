package com.damianzygma.blogappweb.controller;

import com.damianzygma.blogappweb.dto.PostDto;
import com.damianzygma.blogappweb.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

//    create handler method, GET request and return model and view
    @GetMapping("/admin/posts")
    public String post(Model model){
        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "/admin/posts";
    }


}