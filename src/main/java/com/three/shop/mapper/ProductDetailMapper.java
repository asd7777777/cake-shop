package com.three.shop.mapper;


import com.three.shop.domain.entity.ProductDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description：
 *
 * @author sheng
 * @date 2020/7/14 21:04
 * @since JDK 1.8
 */
public interface ProductDetailMapper {
    int deleteByPrimaryKey(Integer productDetailId);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Integer productDetailId);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);

    /**
     * 根据传入的商品 id 和尺寸查找产品信息
     *
     * @param productId 商品 id
     * @param size      尺寸
     * @return 商品信息集合
     */
    ProductDetail selectByProductIdAndSize(@Param("productId") int productId, @Param("size") String size);

    List<ProductDetail> selectById(@Param("productId") int productId);

    int updateStockById(@Param("productId") int productId, @Param("stock") int stock);
}
