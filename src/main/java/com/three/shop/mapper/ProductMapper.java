package com.three.shop.mapper;

import com.three.shop.domain.entity.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

}