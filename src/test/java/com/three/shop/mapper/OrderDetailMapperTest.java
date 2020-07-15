package com.three.shop.mapper;

import com.three.shop.domain.entity.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-mybatis.xml"})
public class OrderDetailMapperTest {
@Resource
OrderDetailMapper orderDetailMapper;
    @Test
    public void insertOrderDetail() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductPic("123");
        orderDetail.setProductName("12312131");
        orderDetail.setProductId(1);
        orderDetail.setCount(1);
        orderDetail.setPrice(new BigDecimal(1.00));
        orderDetail.setOrderNo("78946");
        orderDetailMapper.insertOrderDetail(orderDetail);
    }
}