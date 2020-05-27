package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule<Product> {

    @Override
    public void validate(Product product) throws ProductValidationException {
        if (product.getDiscount() == null ){
            product.setDiscount(BigDecimal.valueOf(0));
        }

        if ((product.getDiscount().compareTo(BigDecimal.valueOf(0)) < 0) || (product.getDiscount().compareTo(BigDecimal.valueOf(100))) > 0) {
            throw new ProductValidationException("Product discount is invalid");
        }

        if ((product.getPrice().compareTo(BigDecimal.valueOf(20L)) <= 0) && (product.getDiscount().compareTo(BigDecimal.valueOf(0)) > 0)){
            throw new ProductValidationException("Products with price 20$ or lower are not applicable with discount");
        }
    }
}
