package com.three.shop.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class ProductDetail implements Serializable {

    /**
     * 商品详情ID
     */
    private Integer productDetailId;

    /**
     * 商品尺寸
     */
    private String size;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品上架时间
     */
    private Date createTime;

    /**
     * 商品下架时间
     */
    private Date unloadTime;

    /**
     * 商品状态 ,1代表正常,0代表下架
     */
    private Integer status;

    /**
     * 商品图片
     */
    private String img;

    /**
     * 外键
     */
    private Integer productId;

    /**
     * 商品库存
     */
    private Integer stock;
}
