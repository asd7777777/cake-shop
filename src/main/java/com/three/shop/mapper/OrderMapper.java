package com.three.shop.mapper;

import com.three.shop.domain.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectAll(@Param("userId") int userId, @Param("limit") int limit, @Param("size") int size);

    List<Order> selectOrdersByStatus(@Param("status") int status, @Param("userId") int userId, @Param("limit") int limit, @Param("size") int size);

    Order selectByOrderNo(@Param("orderNo") String orderNo);

    int insertOrder(@Param("order") Order order);

    int deleteOrderByOrderNo(@Param("orderNo") String orderNo);
}