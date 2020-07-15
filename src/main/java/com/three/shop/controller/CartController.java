package com.three.shop.controller;

import com.three.shop.domain.dto.CartDto;
import com.three.shop.domain.dto.ResultDto;
import com.three.shop.domain.entity.Cart;
import com.three.shop.domain.vo.ResultVo;
import com.three.shop.exception.ServiceException;
import com.three.shop.service.CartService;
import com.three.shop.utils.StatusEnum;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description：对应 shoppingCar.html 的功能页面
 *
 * @author sheng
 * @date 2020/7/13 17:47
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private CartService cartService;

    /**
     * 展示购物车
     *
     * @param userId 用户 id
     * @return 封装了查询结果的 JavaBean
     */
    @GetMapping("/showCart")
    public ResultVo<ResultDto<List<Cart>>> showCart(@RequestParam("userId") String userId) {
        // 查询
        ResultDto<List<Cart>> resultDto = cartService.findCartByUserId(userId);
        // 判断结果
        if (resultDto.getData() != null) {
            return ResultVo.success(resultDto, StatusEnum.SUCCESS);
        } else {
            return ResultVo.error(StatusEnum.SERVICE_ERROR);
        }
    }

    /**
     * 修改商品数量
     *
     * @param cartId   购物车 id
     * @param quantity 数量
     * @return 封装了修改结果的 JavaBean
     * @throws ServiceException 异常
     */
    @PostMapping("/updateCart")
    public ResultVo<ResultDto<Integer>> updateCart(@RequestParam("cartId") String cartId,
                                                   @RequestParam("quantity") String quantity) throws ServiceException {
        // 修改
        ResultDto<Integer> resultDto = cartService.updateCart(cartId, quantity);
        return ResultVo.success(resultDto, StatusEnum.SUCCESS);
    }

    @PostMapping("/saveCart")
    public ResultVo<ResultDto<Integer>> saveCart(@RequestBody CartDto cartDto) throws ServiceException {
        // 保存
        ResultDto<Integer> resultDto = cartService.saveCart(cartDto);
        // 判断
        if (resultDto.getData() != null) {
            return ResultVo.success(resultDto, StatusEnum.SUCCESS);
        } else {
            return ResultVo.error(StatusEnum.SERVICE_ERROR);
        }
    }

    /**
     * 删除
     *
     * @param cartId 购物车 id
     * @return 封装了修改结果的 JavaBean
     * @throws ServiceException 异常
     */
    @PostMapping("/deleteCart")
    public ResultVo<ResultDto<Integer>> deleteCart(@RequestParam("cartId") String cartId) throws ServiceException {
        // 删除
        ResultDto<Integer> resultDto = cartService.deleteCart(cartId);
        if (resultDto.getData() != null) {
            return ResultVo.success(resultDto, StatusEnum.SUCCESS);
        } else {
            return ResultVo.error(StatusEnum.SERVICE_ERROR);
        }
    }
}
