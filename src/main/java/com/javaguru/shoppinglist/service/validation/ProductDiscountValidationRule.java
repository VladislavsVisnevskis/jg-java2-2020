package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule<ProductDto> {

    @Override
    public void validate(ProductDto productDto) throws ProductValidationException {
        if (productDto.getDiscount() == null ){
            throw new ProductValidationException("Please, enter the discount");
        }

        if ((productDto.getDiscount().compareTo(BigDecimal.valueOf(0)) < 0) || (productDto.getDiscount().compareTo(BigDecimal.valueOf(100))) > 0) {
            throw new ProductValidationException("Product discount is invalid");
        }

        if ((productDto.getPrice().compareTo(BigDecimal.valueOf(20L)) <= 0) && (productDto.getDiscount().compareTo(BigDecimal.valueOf(0)) > 0)){
            throw new ProductValidationException("Products with price 20$ or lower are not applicable with discount");
        }
    }
}
