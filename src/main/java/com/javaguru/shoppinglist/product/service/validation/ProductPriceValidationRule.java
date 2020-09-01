package com.javaguru.shoppinglist.product.service.validation;

import com.javaguru.shoppinglist.product.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductPriceValidationRule implements ProductValidationRule <ProductDto> {

    @Override
    public void validate(ProductDto productDto) throws ProductValidationException {
        if ((productDto.getPrice().compareTo(BigDecimal.valueOf(0)) < 0)) {
            throw new ProductValidationException("Product price is invalid");
        }
    }
}
