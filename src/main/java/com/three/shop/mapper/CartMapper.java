package com.three.shop.mapper;

import com.three.shop.domain.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description：对应购物车的相关 crud 操作
 *
 * @author sheng
 * @date 2020/7/14 10:00
 * @since JDK 1.8
 */
public interface CartMapper {
    /**
     * 根据传入的 userId 查询当前用户的购物车数据
     *
     * @param userId 用户 id
     * @return 购物车集合
     */
    List<Cart> selectByUserId(@Param("userId") int userId);

    /**
     * 根据传入的 userId productId 查询当前用户的购物车数据
     *
     * @param userId    用户 id
     * @param productId 商品 id
     * @return 购物车集合
     */
    List<Cart> selectByUserIdAndProductId(@Param("userId") int userId, @Param("productId") int productId);

    /**
     * 根据传入的 Cart 对象进行修改：数量、状态(假删除)
     *
     * @param cart Cart 对象
     * @return 影响行数
     */
    int updateCart(@Param("cart") Cart cart);

    /**
     * 根据传入的 Cart 对象进行插入
     *
     * @param cart Cart 对象
     * @return 影响行数
     */
    int insertCart(@Param("cart") Cart cart);
}