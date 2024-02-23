package com.damianzygma.blogappweb.service;

import com.damianzygma.blogappweb.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();

    void createPost(PostDto postDto);

    PostDto findPostById(Long postId);

    void updatePost(PostDto postDto);

}
