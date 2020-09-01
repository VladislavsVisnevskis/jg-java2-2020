package com.javaguru.shoppinglist.product.service.validation;

import com.javaguru.shoppinglist.product.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule<ProductDto> {

    @Override
    public void validate(ProductDto productDto) throws ProductValidationException {
        if (!productDto.getName().matches("[A-Za-z0-9\\s*]+") || productDto.getName().length() < 3 || productDto.getName().length() > 32) {
            throw new ProductValidationException("Product name is invalid - only letters and numbers are allowed" + '\n' + "Minimal Length 3 and maximal 32 characters");
        }
    }
}