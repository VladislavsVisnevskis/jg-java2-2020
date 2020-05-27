package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductValidationService {

    private Set<ProductValidationRule> validationRules = new HashSet<>();

    public ProductValidationService(){
        validationRules.add(new ProductCategoryValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
        validationRules.add(new ProductNameValidationRule());
        validationRules.add(new ProductPriceValidationRule());
    }

    public List<String> validate (Product product){
        List<String> errorMessages = new ArrayList<>();
        validationRules.forEach(rule -> {
            try {
                rule.validate(product);
            }
            catch (Exception e){
                errorMessages.add(e.getMessage());
            }
        });
        return errorMessages;
    }
}

