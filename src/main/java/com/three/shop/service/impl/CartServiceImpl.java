package com.three.shop.service.impl;

import com.three.shop.domain.dto.CartDto;
import com.three.shop.domain.dto.ResultDto;
import com.three.shop.domain.entity.Cart;
import com.three.shop.domain.entity.ProductDetail;
import com.three.shop.exception.ServiceException;
import com.three.shop.mapper.CartMapper;
import com.three.shop.mapper.ProductDetailMapper;
import com.three.shop.service.CartService;
import com.three.shop.utils.JudgeEmptyUtils;
import com.three.shop.utils.Status;
import com.three.shop.utils.StatusEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * Description：
 *
 * @author sheng
 * @date 2020/7/14 11:33
 * @since JDK 1.8
 */
@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartMapper cartMapper;
    @Resource
    private ProductDetailMapper productDetailMapper;

    @Override
    public ResultDto<List<Cart>> findCartByUserId(String userId) {
        // 进行非空判断
        if (JudgeEmptyUtils.judgeObjectNull(userId)) {
            // 参数异常
            return ResultDto.error(StatusEnum.PARAM_ERROR);
        }
        // 转换成整型
        int id = 0;
        // 可能出现错误
        try {
            id = Integer.parseInt(userId);
        } catch (NumberFormatException e) {
            // 参数异常
            return ResultDto.error(StatusEnum.PARAM_ERROR);
        }
        // 进行查询
        List<Cart> carts = cartMapper.selectByUserId(id);
        // 判断是否查询成功
        if (carts != null) {
            // 查询成功
            return ResultDto.success(carts, StatusEnum.SUCCESS);
        } else {
            return ResultDto.error(StatusEnum.DAO_ERROR);
        }
    }

    @Override
    public ResultDto<Integer> updateCart(String cartId, String quantity) throws ServiceException {
        // 非空判断
        boolean flag = JudgeEmptyUtils.judgeObjectNull(cartId, quantity);
        if (flag) {
            // 参数异常
            return ResultDto.error(StatusEnum.PARAM_ERROR);
        }
        // 购物车 id
        int id = 0;
        // 数量
        int num = 0;
        try {
            id = Integer.parseInt(cartId);
            num = Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new ServiceException(Status.SERVICE_ERROR);
        }
        // 判断 id 信息
        if (id <= 0) {
            return ResultDto.error(StatusEnum.PARAM_ERROR);
        }
        // 查询购物车信息
        Cart cartInfo = cartMapper.selectByCartId(id);
        // 非空判断
        if (cartInfo == null) {
            return ResultDto.error(StatusEnum.PARAM_ERROR);
        }
        // 查询库存信息
        // 查询当前商品的库存
        ProductDetail productDetail = null;
        try {
            // 因为 size 不能设置为 unique，如果添加商品时同一个商品的 size 不添加判断，那么有可能重复，则有可能查询多个
            productDetail = productDetailMapper.selectByProductIdAndSize(cartInfo.getProductId(), cartInfo.getProductSize());
        } catch (Exception e) {
            return ResultDto.error(StatusEnum.DAO_ERROR);
        }
        // 非空判断
        if (productDetail == null) {
            return ResultDto.error(StatusEnum.DAO_ERROR);
        }
        // 判断库存，判断数量
        if (num > productDetail.getStock() || num < 1) {
            return ResultDto.error(StatusEnum.STOCK_ERROR);
        }
        Cart cart = new Cart();
        // 设置数据
        cart.setCartId(id);
        cart.setProductQuantity(num);
        // 修改
        int rows = cartMapper.updateCart(cart);
        // 判断修改结果
        if (rows > 0) {
            return ResultDto.success(rows, StatusEnum.SUCCESS);
        } else {
            return ResultDto.error(StatusEnum.ERROR);
        }
    }

    @Override
    public ResultDto<Integer> saveCart(CartDto cartDto) throws ServiceException {
        // 要排除的属性值
        String cartId = "cartId";
        String productPic = "productPic";
        String productName = "productName";
        String productAttr = "productAttr";
        String status = "status";
        // 非空判断，排除非必要属性
        boolean flag = JudgeEmptyUtils.getMethodJudgeFullPropertyEmpty(cartDto, cartId, productPic, productName, productAttr, status);
        if (flag) {
            // 参数异常
            return ResultDto.error(StatusEnum.PARAM_ERROR);
        }
        // 创建对象，并赋值
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartDto, cart);
        // 查询当前用户是否已经添加过该商品进购物车
        List<Cart> carts = cartMapper.selectByUserIdAndProductId(cartDto.getUserId(), cartDto.getProductId());
        // 查询当前商品的库存
        ProductDetail productDetail = null;
        try {
            // 因为 size 不能设置为 unique，如果添加商品时同一个商品的 size 不添加判断，那么有可能重复，则有可能查询多个
            productDetail = productDetailMapper.selectByProductIdAndSize(cart.getProductId(), cart.getProductSize());
        } catch (Exception e) {
            return ResultDto.error(StatusEnum.DAO_ERROR);
        }
        // 存储库存
        int stock = 0;
        // 非空判断
        if (productDetail != null) {
            stock = productDetail.getStock();
        }
        // 存储相同的购物车数据
        Cart oldCart = null;
        // 非空判断
        if (carts != null) {
            // 循环判断
            for (Cart temp : carts) {
                // 产品的尺寸一致则说明已经存在购物车中
                if (Objects.equals(temp.getProductSize(), cart.getProductSize())) {
                    oldCart = temp;
                }
            }
        }
        // 用来存储保存结果
        int rows = 0;
        // 非空判断，不为空则存在
        if (oldCart != null) {
            // 判断是否是移除的购物车
            if (Objects.equals(0, oldCart.getStatus())) {
                // 移除的购物车，设置状态为 1，并将数量设置为新添加的数量
                // 判断库存
                if (stock < cart.getProductQuantity()) {
                    // 库存不足
                    return ResultDto.error(StatusEnum.STOCK_ERROR);
                }
                // 设置 cartId、status
                cart.setCartId(oldCart.getCartId());
                cart.setStatus(1);
                // 修改
                rows = cartMapper.updateCart(cart);
            } else {
                // 不是移除的购物车，添加数量，要先判断库存是否足够
                // 总数量
                int quantity = oldCart.getProductQuantity() + cart.getProductQuantity();
                // 判断库存
                if (stock < quantity) {
                    // 库存不足
                    return ResultDto.error(StatusEnum.STOCK_ERROR);
                }
                // 设置数据
                cart.setCartId(oldCart.getCartId());
                cart.setStatus(1);
                cart.setProductQuantity(quantity);
                // 修改
                rows = cartMapper.updateCart(cart);
            }
        } else {
            // 判断库存
            if (stock < cart.getProductQuantity()) {
                return ResultDto.error(StatusEnum.STOCK_ERROR);
            }
            // 不存在则进行保存
            rows = cartMapper.insertCart(cart);
        }
        // 判断是否成功
        if (rows > 0) {
            return ResultDto.success(rows, StatusEnum.SUCCESS);
        } else {
            return ResultDto.error(StatusEnum.DAO_ERROR);
        }
    }

    @Override
    public ResultDto<Integer> deleteCart(String cartId) {
        // 非空判断
        if (JudgeEmptyUtils.judgeObjectNull(cartId)) {
            return ResultDto.error(StatusEnum.PARAM_ERROR);
        }
        // 转换成整型
        int id = 0;
        try {
            id = Integer.parseInt(cartId);
        } catch (NumberFormatException e) {
            return ResultDto.error(StatusEnum.PARAM_ERROR);
        }
        // 判断是否符合正常的 id
        if (id <= 0) {
            return ResultDto.error(StatusEnum.PARAM_ERROR);
        }
        Cart cart = new Cart();
        // 设置数据
        cart.setCartId(id);
        cart.setStatus(0);
        // 修改 status
        int rows = cartMapper.updateCart(cart);
        // 判断
        if (rows > 0) {
            return ResultDto.success(rows, StatusEnum.SUCCESS);
        } else {
            return ResultDto.error(StatusEnum.ERROR);
        }
    }
}
