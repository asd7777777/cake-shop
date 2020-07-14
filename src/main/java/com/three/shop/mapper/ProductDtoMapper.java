package com.three.shop.mapper;

import com.three.shop.domain.dto.ProductDto;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
public interface ProductDtoMapper {
    /**
     * 根据商品ID查询商品,使用级联查询
     * @param productId 商品id
     * @return 返回查询到的对象
     */
    ProductDto selectProductByProductId(@Param("productId") int productId);
}
