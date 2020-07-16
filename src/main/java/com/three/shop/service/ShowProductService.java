package com.three.shop.service;

import com.three.shop.domain.dto.ProductDto;
import com.three.shop.domain.entity.Product;

/**
 * @author Administrator
 */
public interface ShowProductService {
    /**
     * 根据商品id查询商品,这里涉及到一对多查询,一种商品可能有多种尺寸和价格以及图片
     * @param productId 商品id
     * @return 返回查询到的商品对象
     */
    ProductDto showProductService(int productId);
}
