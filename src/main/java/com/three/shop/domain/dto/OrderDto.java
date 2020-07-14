package com.three.shop.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private int userId;
    private List<CartsDto> carts;
    private String address;
}
