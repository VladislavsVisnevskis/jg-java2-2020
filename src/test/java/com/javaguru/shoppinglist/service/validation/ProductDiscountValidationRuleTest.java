package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductDiscountValidationRuleTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    ProductDiscountValidationRule victim = new ProductDiscountValidationRule();
    ProductDto input;

    @Test
    public void shouldThrowProductDiscountValidationRule() {
        input = product(BigDecimal.valueOf(101));
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Products with price 20$ or lower are not applicable with discount");
        victim.validate(input);
    }

    private ProductDto product(BigDecimal discount){
        ProductDto productDto = new ProductDto();
        productDto.setDiscount(discount);
        return productDto;
    }
}