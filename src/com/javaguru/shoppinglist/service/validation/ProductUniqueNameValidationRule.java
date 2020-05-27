package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;

import java.util.Collection;

public class ProductUniqueNameValidationRule{

    public void validate(Product product, ProductRepository<Product> productRepository) throws ProductValidationException {
        if(productRepository.findAllProducts().values().stream()
                .anyMatch(stock -> stock.getName().equals(product.getName()))){
            throw new ProductValidationException ("Product with such name already exists");
        }
    }
}
