package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule<Product> {

    @Override
    public void validate(Product product) throws ProductValidationException {
        if (!product.getName().matches("[A-Za-z0-9]+") || product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ProductValidationException("Product name is invalid - only letters and numbers are allowed" + '\n' + "Minimal Length 3 and maximal 32 characters");
        }
    }
}