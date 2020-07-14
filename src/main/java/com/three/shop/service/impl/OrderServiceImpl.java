package com.three.shop.service.impl;

import com.three.shop.domain.dto.CartsDto;
import com.three.shop.domain.dto.OrderDto;
import com.three.shop.domain.entity.Order;
import com.three.shop.domain.entity.OrderDetail;
import com.three.shop.domain.entity.Product;
import com.three.shop.domain.entity.User;
import com.three.shop.domain.vo.OrderDetailVo;
import com.three.shop.domain.vo.OrderVo;
import com.three.shop.exception.ServiceException;
import com.three.shop.mapper.OrderDetailMapper;
import com.three.shop.mapper.OrderMapper;
import com.three.shop.mapper.ProductMapper;
import com.three.shop.mapper.UserMapper;
import com.three.shop.service.OrderService;
import com.three.shop.utils.GenerateCodeUtil;
import com.three.shop.utils.Status;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    OrderDetailMapper orderDetailMapper;
    @Resource
    ProductMapper productMapper;

    //查询全部的OrderVo
    @Override
    public List<OrderVo> orderList(int userId, int page, int size) {
        List<Order> orders = orderMapper.selectAll(userId, (page-1)*size, size);
        List<OrderVo> orderVos = setOrderVos(orders);
        return orderVos;
    }

    //根据status查询OrderVo
    @Override
    public List<OrderVo> findListByStatus(int status, int userId, int page, int size) {
        List<Order> orders = orderMapper.selectOrdersByStatus(status, userId, (page-1)*size, size);
        List<OrderVo> orderVos = setOrderVos(orders);
        return orderVos;
    }

    //填充List<OrderVo>
    private List<OrderVo> setOrderVos(List<Order> orders) {
        List<OrderVo> orderVos = new ArrayList<>();
        for (Order order : orders) {
            OrderVo orderVo = new OrderVo();
            BeanUtils.copyProperties(order,orderVo);

            User user = userMapper.selectByPrimaryKey(order.getUserId());
            orderVo.setUserName(user.getUsername());

            List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderNo(order.getOrderNo());
            BeanUtils.copyProperties(orderDetails.get(0),orderVo);

            orderVos.add(orderVo);
        }
        return orderVos;
    }

    @Override
    public OrderDetailVo findDetailByOrderNo(String orderNo, int page, int size) {
        OrderDetailVo orderDetailVo = new OrderDetailVo();

        List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderNo(orderNo);
        orderDetailVo.setOrderDetails(orderDetails);

        Order order = orderMapper.selectByOrderNo(orderNo);
        BeanUtils.copyProperties(order, orderDetailVo);

        User user = userMapper.selectByPrimaryKey(order.getUserId());
        orderDetailVo.setUsername(user.getUsername());
        orderDetailVo.setPhone(user.getPhone());

        return orderDetailVo;
    }

    @Override

    public int generateOrder(OrderDto orderDto){
        String orderNo = GenerateCodeUtil.createCodeNum("OR");
        List<CartsDto> cartsDtos = orderDto.getCarts();

        //总价
        BigDecimal total = new BigDecimal(0);
        for (CartsDto cartsDto : cartsDtos) {
            //减少库存
            Integer productId = cartsDto.getProductId();
            Product product = productMapper.selectByPrimaryKey(productId);
            //获取库存
            Integer stock = product.getStock();
            Integer count = cartsDto.getCount();
            if (stock >= count) {
                stock -= count;
                int i = productMapper.updateStockById(productId, stock);
//                if (i == 0) {
//                    throw new ServiceException(Status.SERVICE_ERROR);
//                }
                //该商品总价
                BigDecimal num = new BigDecimal(count);
                BigDecimal price = product.getPrice();
                BigDecimal multiply = price.multiply(num);
                //全部商品总价
                total.add(multiply);
            } else {
//                throw new ServiceException(Status.SERVICE_ERROR);
                return 0;
            }
            //保存订单详情
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderNo(orderNo);
            orderDetail.setCount(count);
            orderDetail.setPrice(product.getPrice());
            orderDetail.setProductId(productId);
            orderDetail.setProductName(product.getName());
            orderDetail.setProductPic(product.getImg());
            int insert = orderDetailMapper.insert(orderDetail);
//            if (insert == 0) {
//                throw new ServiceException(Status.SERVICE_ERROR);
//                return 0;
//            }
        }
        //保存订单
        Order order = new Order();
        order.setAddress(orderDto.getAddress());
        order.setOrderNo(orderNo);
        order.setTotal(total);
        order.setUserId(orderDto.getUserId());
        int j = orderMapper.insert(order);

        return j;
    }


}
