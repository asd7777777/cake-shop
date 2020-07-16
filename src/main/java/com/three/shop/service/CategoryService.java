package com.three.shop.service;

import com.three.shop.domain.dto.ResultDto;
import com.three.shop.domain.entity.Category;

import java.util.List;

/**
 * Description：对应类别的相关操作
 *
 * @author sheng
 * @date 2020/7/15 19:58
 * @since JDK 1.8
 */
public interface CategoryService {
    /**
     * 查询所有的类别
     *
     * @return 封装了查询数据的 JavaBean
     */
    ResultDto<List<Category>> findCategory();
}
