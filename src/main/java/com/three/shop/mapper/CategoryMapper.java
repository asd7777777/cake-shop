package com.three.shop.mapper;

import com.three.shop.domain.entity.Category;

import java.util.List;

/**
 * Description：
 *
 * @author sheng
 * @date 2020/7/15 19:50
 * @since JDK 1.8
 */
public interface CategoryMapper {
    /**
     * 查询所有的类别
     *
     * @return 类别集合
     */
    List<Category> selectAll();
}