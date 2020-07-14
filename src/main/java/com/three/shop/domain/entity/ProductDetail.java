package com.three.shop.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * Description：
 *
 * @author sheng
 * @date 2020/7/14 21:04
 * @since JDK 1.8
 */
@Data
public class ProductDetail {
    /**
     * 主键,商品详情id
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
     * 上架时间
     */
    private Date createTime;

    /**
     * 下架时间
     */
    private Date unloadTime;

    /**
     * 1代表正常,0代表下架
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