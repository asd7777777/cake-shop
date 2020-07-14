package com.three.shop.controller;

import com.three.shop.domain.dto.OrderDto;
import com.three.shop.domain.vo.OrderDetailVo;
import com.three.shop.domain.vo.OrderVo;
import com.three.shop.exception.ServiceException;
import com.three.shop.service.OrderService;
import com.three.shop.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController()
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    @GetMapping("/allList")
    public ResponseEntity<List<OrderVo>> allList(int userId, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        List<OrderVo> orderVos = orderService.orderList(userId, page, size);
        return ResponseEntity.success(orderVos);
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrderVo>> list(int status, int userId, @RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size){
        List<OrderVo> orderVos = orderService.findListByStatus(status, userId, page, size);
        return ResponseEntity.success(orderVos);
    }

    @GetMapping("/orderDetail")
    public ResponseEntity<OrderDetailVo> orderDetail(String orderNo, @RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size) {
        OrderDetailVo orderDetailVo = orderService.findDetailByOrderNo(orderNo, page, size);
        return ResponseEntity.success(orderDetailVo);
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Integer> addOrder(@RequestBody OrderDto orderDto){
        int count = orderService.generateOrder(orderDto);
        return ResponseEntity.success(count);
    }
}
