package com.three.shop.domain.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetail {
    private Integer orderDetailId;

    private String orderNo;

    private Integer productId;

    private Integer count;

    private BigDecimal price;

    private String productPic;

    private String productName;
}