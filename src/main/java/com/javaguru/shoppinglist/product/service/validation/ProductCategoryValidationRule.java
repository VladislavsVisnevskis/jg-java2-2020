package com.javaguru.shoppinglist.product.service.validation;

import com.javaguru.shoppinglist.product.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryValidationRule implements ProductValidationRule<ProductDto>{

    @Override
    public void validate(ProductDto productDto) throws ProductValidationException {
        if(productDto.getCategory() == null || productDto.getCategory().equals("")){
            throw new ProductValidationException("Choose the product category");
        }
    }
}
