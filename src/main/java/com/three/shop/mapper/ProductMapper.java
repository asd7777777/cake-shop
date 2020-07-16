package com.three.shop.mapper;

import com.three.shop.domain.entity.Product;
import org.apache.ibatis.annotations.Param;

/**
 * Description：
 *
 * @author sheng
 * @date 2020/7/14 21:04
 * @since JDK 1.8
 */
public interface ProductMapper {

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

}