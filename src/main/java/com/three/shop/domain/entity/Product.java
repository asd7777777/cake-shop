package com.three.shop.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
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
    * 商品图片
    */
    private String img;

    /**
    * 商品尺寸
    */
    private String size;

    /**
    * 商品价格
    */
    private BigDecimal price;

    /**
    * 商品库存
    */
    private Integer stock;

    /**
    * 上架时间
    */
    private Date createTime;

    /**
    * 下架时间
    */
    private Date underTime;

    /**
    * 1代表正常,0代表下架
    */
    private Integer status;
}