package com.three.shop.service.impl;

import com.three.shop.domain.dto.ProductDto;
import com.three.shop.mapper.ProductDtoMapper;
import com.three.shop.service.ShowProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class ShowProductServiceImpl implements ShowProductService {
    @Resource
    ProductDtoMapper productDtoMapper;
    @Override
    public ProductDto showProductService(int productId) {
        ProductDto productDto = productDtoMapper.selectProductByProductId(productId);
        return productDto;
    }
}
