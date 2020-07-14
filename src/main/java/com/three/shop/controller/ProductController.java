package com.three.shop.controller;

import com.three.shop.domain.entity.Product;
import com.three.shop.service.ShowProductService;
import com.three.shop.utils.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
public class ProductController {
    @Resource
    ShowProductService showProductService;
    @GetMapping("/product")
    public ResponseEntity<Product> showProduct(int productId) {
        Product product = showProductService.showProductService(productId);
        return ResponseEntity.success(product);
    }
}
