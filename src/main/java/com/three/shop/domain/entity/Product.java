package com.three.shop.domain.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Product {
    /**
    * 商品id
    */
    private Integer productId;

    /**
    * 商品标题
    */
    private String title;

    /**
    * 商品描述
    */
    private String name;

    /**
    * 商品品牌
    */
    private String brand;




    /**
     * 商品详情对象
     */
    private List<ProductDetail> productDetails;
}