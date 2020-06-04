package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule <ProductDto> {

    @Override
    public void validate(ProductDto productDto) throws ProductValidationException {
        if ((productDto.getPrice().compareTo(BigDecimal.valueOf(0)) < 0)) {
            throw new ProductValidationException("Product price is invalid");
        }
    }
}
