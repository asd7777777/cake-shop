package com.three.shop.service;

import com.three.shop.domain.dto.ProductDto;
import com.three.shop.domain.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-mybatis.xml"})
public class ShowProductServiceTest {
    @Resource
    ShowProductService showProductService;
    @Test
    public void showProductService() {
        ProductDto productDto = showProductService.showProductService(1);
        System.out.println(productDto);
    }
}