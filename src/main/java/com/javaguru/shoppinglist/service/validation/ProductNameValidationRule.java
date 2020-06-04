package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

public class ProductNameValidationRule implements ProductValidationRule<ProductDto> {

    @Override
    public void validate(ProductDto productDto) throws ProductValidationException {
        if (!productDto.getName().matches("[A-Za-z0-9]+") || productDto.getName().length() < 3 || productDto.getName().length() > 32) {
            throw new ProductValidationException("Product name is invalid - only letters and numbers are allowed" + '\n' + "Minimal Length 3 and maximal 32 characters");
        }
    }
}