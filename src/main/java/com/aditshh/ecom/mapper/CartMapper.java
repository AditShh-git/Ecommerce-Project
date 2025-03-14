package com.aditshh.ecom.mapper;

import com.aditshh.ecom.dto.CartDTO;
import com.aditshh.ecom.dto.CartItemDTO;
import com.aditshh.ecom.model.Cart;
import com.aditshh.ecom.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "userId", source = "user.id")
    CartDTO toDTO(Cart Cart);
    @Mapping(target="user.id", source = "userId")
    Cart toEntity(CartDTO cartDTO);

    @Mapping(target="productId", source="product.id")
    CartItemDTO toDTO(CartItem cartItem);

    @Mapping(target="product.id", source="productId")
    CartItem toEntity(CartItemDTO cartItemDTO);
}
