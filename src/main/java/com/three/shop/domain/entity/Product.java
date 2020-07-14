package com.three.shop.domain.entity;

import lombok.Data;

/**
 * Description：
 *
 * @author sheng
 * @date 2020/7/14 21:04
 * @since JDK 1.8
 */
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
}