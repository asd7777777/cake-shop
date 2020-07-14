package com.three.shop.domain.vo;

import com.three.shop.domain.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDetailVo {
    private String orderNo;

    private String username;

    private String phone;

    private BigDecimal total;

    private String address;

    private Integer status;

    private Date createTime;

    private List<OrderDetail> orderDetails;
}
