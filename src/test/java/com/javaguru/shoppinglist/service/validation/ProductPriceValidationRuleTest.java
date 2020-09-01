package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.product.dto.ProductDto;
import com.javaguru.shoppinglist.product.service.validation.ProductPriceValidationRule;
import com.javaguru.shoppinglist.product.service.validation.ProductValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class ProductPriceValidationRuleTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    ProductPriceValidationRule victim = new ProductPriceValidationRule();
    ProductDto input;

    @Test
    public void shouldThrowProductPriceValidationRule() {
        input = product(BigDecimal.valueOf(-1));
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Product price is invalid");
        victim.validate(input);
    }

    private ProductDto product(BigDecimal price){
        ProductDto productDto = new ProductDto();
        productDto.setPrice(price);
        return productDto;
    }
}