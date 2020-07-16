package com.three.shop.controller;

import com.three.shop.domain.dto.ResultDto;
import com.three.shop.domain.entity.Category;
import com.three.shop.domain.vo.ResultVo;
import com.three.shop.service.CategoryService;
import com.three.shop.utils.StatusEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description：
 *
 * @author sheng
 * @date 2020/7/15 20:34
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    /**
     * 查找所有的类别
     *
     * @return 封装了查询数据的 JavaBean
     */
    @GetMapping("/findCategory")
    public ResultVo<ResultDto<List<Category>>> findCategory() {
        // 查询数据
        ResultDto<List<Category>> resultDto = categoryService.findCategory();
        // 判断，返回数据
        if (resultDto.getData() != null) {
            return ResultVo.success(resultDto, StatusEnum.SUCCESS);
        } else {
            return ResultVo.error(StatusEnum.ERROR);
        }
    }
}
