package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public interface ProductValidationRule<Product> {

    void validate (Product product) throws ProductValidationException;

    default void checkNotNull(Product product) throws ProductValidationException {
        if (product == null){
            throw new ProductValidationException("Product must not be null");
        }
    }
}
