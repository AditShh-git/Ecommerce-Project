package com.aditshh.ecom.mapper;

import com.aditshh.ecom.dto.CommentDTO;
import com.aditshh.ecom.dto.ProductDTO;
import com.aditshh.ecom.model.Comment;
import com.aditshh.ecom.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "image", source = "image") //add mapping
    ProductDTO toDTO(Product product);

    @Mapping(target = "image", source = "image") //add mapping
    Product toEntity(ProductDTO productDTO);

    @Mapping(target = "userId",source = "user.id")
    CommentDTO toDTO(Comment comment);
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "product", ignore = true)
    Comment toEntity(CommentDTO commentDTO);
}