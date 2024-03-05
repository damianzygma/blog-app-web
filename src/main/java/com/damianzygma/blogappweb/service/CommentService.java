package com.damianzygma.blogappweb.service;

import com.damianzygma.blogappweb.dto.CommentDto;

public interface CommentService {
    void creatComment(String postUrl, CommentDto commentDto);
}
