package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class ProductNameValidationRuleTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    ProductNameValidationRule victim = new ProductNameValidationRule();
    ProductDto input;

    @Test
    public void shouldThrowProductNameValidationRule() {
        input = product("#java");
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Product name is invalid - only letters and numbers are allowed" + '\n' + "Minimal Length 3 and maximal 32 characters");
        victim.validate(input);
    }

    private ProductDto product(String name){
        ProductDto productDto = new ProductDto();
        productDto.setName(name);
        return productDto;
    }
}
