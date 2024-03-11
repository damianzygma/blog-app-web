package com.damianzygma.blogappweb.service;

import com.damianzygma.blogappweb.dto.CommentDto;

import java.util.List;

public interface CommentService {
    void creatComment(String postUrl, CommentDto commentDto);

    List<CommentDto> findAllComments();

    void deleteComment(Long commentId);

    List<CommentDto> findCommentsByPost();
}
