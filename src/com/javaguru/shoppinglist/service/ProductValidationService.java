package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.Product;

import java.math.BigDecimal;

public class ProductValidationService {

    public static void validate(Product product) throws ProductValidationException {

        if (!product.getName().matches("[A-Za-z0-9]+") || product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ProductValidationException("Product name is invalid");
        }

        if ((product.getPrice().compareTo(BigDecimal.valueOf(0)) < 0)) {
            throw new ProductValidationException("Product price is invalid");
        }

        if (product.getDiscount() == null ){
            product.setDiscount(BigDecimal.valueOf(0));
        }

        if ((product.getDiscount().compareTo(BigDecimal.valueOf(0)) < 0) || (product.getDiscount().compareTo(BigDecimal.valueOf(100))) > 0) {
            throw new ProductValidationException("Product discount is invalid");
        }

        if(product.getCategory() == null || product.getCategory().equals("")){
            throw new ProductValidationException("Choose the product category");

        }

        product.setActualPrice();
    }
}

