package com.three.shop.service;

import com.three.shop.domain.dto.OrderDto;
import com.three.shop.domain.vo.OrderDetailVo;
import com.three.shop.domain.vo.OrderVo;
import com.three.shop.exception.ServiceException;

import java.util.List;

public interface OrderService {
    List<OrderVo> orderList(int userId, int page, int size);

    List<OrderVo> findListByStatus(int status, int userId, int page, int size);

    OrderDetailVo findDetailByOrderNo(String orderNo, int page, int size);

    int generateOrder(OrderDto orderDto);
}
