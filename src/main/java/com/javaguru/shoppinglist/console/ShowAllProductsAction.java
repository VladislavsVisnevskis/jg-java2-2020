package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ShowAllProductsAction implements MenuAction {

    private final ProductService productService;

    public ShowAllProductsAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        productService.showAllProducts();
    }

    @Override
    public String getMenuActionName() {
        return "Show all products";
    }
}
