package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule <Product> {

    @Override
    public void validate(Product product) throws ProductValidationException {
        if ((product.getPrice().compareTo(BigDecimal.valueOf(0)) < 0)) {
            throw new ProductValidationException("Product price is invalid");
        }
    }
}
