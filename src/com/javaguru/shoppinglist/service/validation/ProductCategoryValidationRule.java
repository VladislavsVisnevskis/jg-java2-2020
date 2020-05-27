package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductCategoryValidationRule implements ProductValidationRule<Product>{

    @Override
    public void validate(Product product) throws ProductValidationException {
        if(product.getCategory() == null || product.getCategory().equals("")){
            throw new ProductValidationException("Choose the product category");
        }
    }
}
