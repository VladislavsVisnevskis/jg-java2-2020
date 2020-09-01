package com.javaguru.shoppinglist.product.service.validation;

public interface ProductValidationRule<Product> {

    void validate (Product product) throws ProductValidationException;

    default void checkNotNull(Product product) throws ProductValidationException {
        if (product == null){
            throw new ProductValidationException("Product must not be null");
        }
    }
}
