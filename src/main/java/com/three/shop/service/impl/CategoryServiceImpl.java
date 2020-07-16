package com.three.shop.service.impl;

import com.three.shop.domain.dto.ResultDto;
import com.three.shop.domain.entity.Category;
import com.three.shop.mapper.CategoryMapper;
import com.three.shop.service.CategoryService;
import com.three.shop.utils.StatusEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description：
 *
 * @author sheng
 * @date 2020/7/15 20:00
 * @since JDK 1.8
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public ResultDto<List<Category>> findCategory() {
        // 查询结果
        List<Category> categories = categoryMapper.selectAll();
        // 非空判断
        if (categories != null) {
            return ResultDto.success(categories, StatusEnum.SUCCESS);
        } else {
            return ResultDto.error(StatusEnum.DAO_ERROR);
        }
    }
}
