package com.three.shop.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Description：
 *
 * @author sheng
 * @date 2020/7/14 11:28
 * @since JDK 1.8
 */
@Data
public class CartDto implements Serializable {
    /**
     * 购物车 id，不为空
     */
    private Integer cartId;

    /**
     * 用户id，外键，指向user用户表，不为空
     */
    private Integer userId;

    /**
     * 商品id，外键，指向product商品表，不为空
     */
    private Integer productId;

    /**
     * 商品的图片
     */
    private String productPic;

    /**
     * 商品的名称
     */
    private String productName;

    /**
     * 商品的销售属性
     */
    private String productAttr;

    /**
     * 商品尺寸，不为空
     */
    private String productSize;

    /**
     * 商品单价，不为空
     */
    private BigDecimal productPrice;

    /**
     * 商品的购买数量，不为空
     */
    private Integer productQuantity;

    /**
     * 状态，默认为1使用状态，0为假删除，不为空
     */
    private Integer status;
}
