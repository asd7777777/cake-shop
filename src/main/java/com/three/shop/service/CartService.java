package com.three.shop.service;

import com.three.shop.domain.dto.CartDto;
import com.three.shop.domain.dto.ResultDto;
import com.three.shop.domain.entity.Cart;
import com.three.shop.exception.ServiceException;

import java.util.List;

/**
 * Description：对应 shoppingCar.html 的业务逻辑
 *
 * @author sheng
 * @date 2020/7/14 11:25
 * @since JDK 1.8
 */
public interface CartService {
    /**
     * 根据传入的 userId 查询当前用户的购物车数据
     *
     * @param userId 用户 id
     * @return 封装了购物车信息的 JavaBean
     */
    ResultDto<List<Cart>> findCartByUserId(String userId);

    /**
     * 根据传入的购物车 id、数量修改商品数量
     *
     * @param cartId   购物车 id
     * @param quantity 数量
     * @return 封装了修改结果的 JavaBean
     * @throws ServiceException 可能出现的异常
     */
    ResultDto<Integer> updateCart(String cartId, String quantity) throws ServiceException;

    /**
     * 根据传入的 CartDto 对象进行插入
     *
     * @param cartDto CartDto 对象
     * @return 封装了添加结果的 JavaBean
     * @throws ServiceException 异常
     */
    ResultDto<Integer> saveCart(CartDto cartDto) throws ServiceException;

    /**
     * 根据传入的购物车 id 移除购物车
     *
     * @param cartId 购物车 id
     * @return 封装了修改结果的 JavaBean
     */
    ResultDto<Integer> deleteCart(String cartId);
}
