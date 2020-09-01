package com.javaguru.shoppinglist.shoppingcart.mapper;

import com.javaguru.shoppinglist.product.domain.ProductEntity;
import com.javaguru.shoppinglist.product.dto.ProductDto;
import com.javaguru.shoppinglist.product.mapper.ProductMapper;
import com.javaguru.shoppinglist.shoppingcart.domain.ShoppingCartEntity;
import com.javaguru.shoppinglist.shoppingcart.dto.ShoppingCartDto;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class ShoppingCartMapper {

    private final ProductMapper productMapper;

    public ShoppingCartMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public ShoppingCartDto toDto(ShoppingCartEntity entity){
        ShoppingCartDto dto = new ShoppingCartDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setProductSet(entity.getProductSet());
        dto.setCartTotal(cartTotal(entity));
        return dto;
    }

    private BigDecimal cartTotal(ShoppingCartEntity shoppingCartEntity) {
        if ( shoppingCartEntity.getProductSet() == null || shoppingCartEntity.getProductSet().isEmpty()) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal total = BigDecimal.ZERO;
            for (ProductEntity productEntity : shoppingCartEntity.getProductSet()) {
                ProductDto productDto = productMapper.toDto(productEntity);
                total = total.add(productDto.getActualPrice());
            }
            return total;
        }
    }

    public ShoppingCartEntity toEntity(ShoppingCartDto dto){
        ShoppingCartEntity entity = new ShoppingCartEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setProductSet(dto.getProductSet());
        return entity;
    }
}
