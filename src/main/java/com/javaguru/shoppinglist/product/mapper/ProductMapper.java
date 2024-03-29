package com.javaguru.shoppinglist.product.mapper;

import com.javaguru.shoppinglist.product.domain.ProductEntity;
import com.javaguru.shoppinglist.product.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductMapper {

    public ProductDto toDto(ProductEntity entity){
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setCategory(entity.getCategory());
        dto.setDiscount(entity.getDiscount());
        dto.setDescription(entity.getDescription());
        dto.setActualPrice(dto.getPrice().multiply(BigDecimal.valueOf(100).subtract(dto.getDiscount())).divide(BigDecimal.valueOf(100)));
        return dto;
    }

    public ProductEntity toEntity(ProductDto dto){
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDiscount(dto.getDiscount());
        entity.setCategory(dto.getCategory());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
