package com.aditshh.ecom.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDTO {
    private Long id;
    private Long userId; //usedId
    private List<CartItemDTO> items;
}
