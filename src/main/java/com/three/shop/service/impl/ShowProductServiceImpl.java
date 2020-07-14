package com.three.shop.service.impl;

import com.three.shop.domain.entity.Product;
import com.three.shop.mapper.ProductMapper;
import com.three.shop.service.ShowProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class ShowProductServiceImpl implements ShowProductService {
    @Resource
    ProductMapper productMapper;
    @Override
    public Product showProductService(int productId) {
        Product product = productMapper.selectProductById(productId);
        return product;
    }
}
