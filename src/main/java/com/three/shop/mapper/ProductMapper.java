package com.three.shop.mapper;

import com.three.shop.domain.entity.Product;

/**
 * Description：
 *
 * @author sheng
 * @date 2020/7/14 21:04
 * @since JDK 1.8
 */
public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}