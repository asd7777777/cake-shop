package com.three.shop.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.three.shop.domain.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderVo {
    private String orderNo;

    private String userName;

    private BigDecimal total;

    private String address;

    /**
     * 订单状态 0删除 1待付款 2已发货 3待评价 4订单已完成
     */
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private String productPic;

    private String productName;

    private BigDecimal price;

    private Integer count;
}
