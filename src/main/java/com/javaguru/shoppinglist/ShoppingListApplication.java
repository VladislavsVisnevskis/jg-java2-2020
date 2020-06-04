package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.console.EditMenu;
import com.javaguru.shoppinglist.console.ProductChoiceMenu;
import com.javaguru.shoppinglist.mapper.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.ProductServiceable;
import com.javaguru.shoppinglist.service.validation.*;

import java.util.HashSet;
import java.util.Set;

class ShoppingListApplication {

    public static void main(String[] args) {
        ProductRepository productRepository = new ProductInMemoryRepository();

        Set<ProductValidationRule> rules = new HashSet<>();
        rules.add(new ProductNameValidationRule());
        rules.add(new ProductPriceValidationRule());
        rules.add(new ProductCategoryValidationRule());
        rules.add(new ProductDiscountValidationRule());
        rules.add(new ProductUniqueNameValidationRule(productRepository));

        ProductValidationService productValidationService = new ProductValidationService(rules);
        ProductMapper productMapper = new ProductMapper();
        ProductServiceable productService = new ProductService(productRepository, productValidationService, productMapper);
        EditMenu editMenu = new EditMenu();
        ProductChoiceMenu productChoiceMenu = new ProductChoiceMenu();
        ConsoleUI ui = new ConsoleUI(productService, editMenu, productChoiceMenu);
        ui.execute();
    }
}
