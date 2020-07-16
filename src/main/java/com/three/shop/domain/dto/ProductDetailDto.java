package com.three.shop.domain.dto;

import com.three.shop.domain.entity.ProductDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class ProductDetailDto {
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
     * 商品图片
     */
    private String img;

}
