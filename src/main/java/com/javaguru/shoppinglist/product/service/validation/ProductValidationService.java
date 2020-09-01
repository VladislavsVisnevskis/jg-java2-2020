package com.javaguru.shoppinglist.product.service.validation;

import com.javaguru.shoppinglist.product.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules;

    public ProductValidationService(Set<ProductValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<String> validate (ProductDto productDto){
        List<String> errorMessages = new ArrayList<>();
        validationRules.forEach(rule -> {
            try {
                rule.validate(productDto);
            }
            catch (Exception e){
                errorMessages.add(e.getMessage());
            }
        });
        return errorMessages;
    }
}

