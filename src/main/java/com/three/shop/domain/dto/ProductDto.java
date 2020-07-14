package com.three.shop.domain.dto;

import com.three.shop.domain.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class ProductDto extends Product{

    private List<ProductDetailDto> productDetailDtoList;
}
