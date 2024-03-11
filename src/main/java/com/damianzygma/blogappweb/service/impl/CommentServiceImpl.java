package com.damianzygma.blogappweb.service.impl;

import com.damianzygma.blogappweb.dto.CommentDto;
import com.damianzygma.blogappweb.entity.Comment;
import com.damianzygma.blogappweb.entity.Post;
import com.damianzygma.blogappweb.entity.User;
import com.damianzygma.blogappweb.mapper.CommentMapper;
import com.damianzygma.blogappweb.mapper.PostMapper;
import com.damianzygma.blogappweb.repository.CommentRepository;
import com.damianzygma.blogappweb.repository.PostRepository;
import com.damianzygma.blogappweb.repository.UserRepository;
import com.damianzygma.blogappweb.service.CommentService;
import com.damianzygma.blogappweb.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    private UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              PostRepository postRepository,
                              UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;

    }

    @Override
    public void creatComment(String postUrl, CommentDto commentDto) {

        Post post = postRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
    }

    @Override
    public List<CommentDto> findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(comment -> CommentMapper.mapToCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDto> findCommentsByPost() {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User createdBy = userRepository.findByEmail(email);
        Long userId = createdBy.getId();
        List<Comment> comments = commentRepository.findCommentsByPost(userId);
        return comments.stream()
                .map((comment -> CommentMapper.mapToCommentDto(comment)))
                .collect(Collectors.toList());
    }
}
