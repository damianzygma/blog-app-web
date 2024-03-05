package com.damianzygma.blogappweb.service.impl;

import com.damianzygma.blogappweb.dto.CommentDto;
import com.damianzygma.blogappweb.entity.Comment;
import com.damianzygma.blogappweb.entity.Post;
import com.damianzygma.blogappweb.mapper.CommentMapper;
import com.damianzygma.blogappweb.repository.CommentRepository;
import com.damianzygma.blogappweb.repository.PostRepository;
import com.damianzygma.blogappweb.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void creatComment(String postUrl, CommentDto commentDto) {

        Post post = postRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
    }
}
