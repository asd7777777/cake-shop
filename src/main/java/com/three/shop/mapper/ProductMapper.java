package com.three.shop.mapper;

import com.three.shop.domain.entity.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 根据商品id查询商品
     * @param productId 商品id
     * @return 返回查询到的商品对象
     */
    Product selectProductById(@Param("productId") int productId);
}