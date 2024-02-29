package com.damianzygma.blogappweb.controller;

import com.damianzygma.blogappweb.dto.PostDto;
import com.damianzygma.blogappweb.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogController {

    private PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    // handler method to handle http://localhost:8080/
    @GetMapping("/")
    public String viewBlogPosts(Model model){
        List<PostDto> postsResponse = postService.findAllPosts();
        model.addAttribute("postsResponse", postsResponse);
        return "blog/view_posts";
    }




}
