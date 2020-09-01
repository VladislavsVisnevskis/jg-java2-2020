package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.product.dto.ProductDto;
import com.javaguru.shoppinglist.product.repository.ProductRepository;
import com.javaguru.shoppinglist.product.service.validation.ProductCategoryValidationRule;
import com.javaguru.shoppinglist.product.service.validation.ProductValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductCategoryValidationRuleTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    ProductCategoryValidationRule victim = new ProductCategoryValidationRule();
    ProductDto input;
    ProductRepository productRepository;

    @Test
    public void shouldThrowProductCategoryValidationRule() {
        input = product(null);
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Choose the product category");
        victim.validate(input);
    }

    private ProductDto product(String name){
        ProductDto productDto = new ProductDto();
        productDto.setName("javaGuru");
        return productDto;
    }
}