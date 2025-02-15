package com.aditshh.ecom.service;

import com.aditshh.ecom.dto.CommentDTO;
import com.aditshh.ecom.exception.ResourceNotFoundException;
import com.aditshh.ecom.mapper.CommentMapper;
import com.aditshh.ecom.model.Comment;
import com.aditshh.ecom.model.Product;
import com.aditshh.ecom.model.User;
import com.aditshh.ecom.repo.CommentRepository;
import com.aditshh.ecom.repo.ProductRepository;
import com.aditshh.ecom.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper;

    public CommentDTO addComment(Long productId, Long userId, CommentDTO commentDTO){
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        Comment comment = commentMapper.toEntity(commentDTO);
        comment.setProduct(product);
        comment.setUser(user);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toDTO(savedComment);

    }

    public List<CommentDTO> getCommentsByProduct(Long productId){
        List<Comment> comments = commentRepository.findByProductId(productId);
        return comments.stream()
                .map(commentMapper::toDTO)
                .collect(Collectors.toList());
    }
}
