package com.damianzygma.blogappweb.service;

import com.damianzygma.blogappweb.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();
}
