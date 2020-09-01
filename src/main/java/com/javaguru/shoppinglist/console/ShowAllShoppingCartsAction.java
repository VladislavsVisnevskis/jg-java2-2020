package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.shoppingcart.service.ShoppingCartService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(7)
public class ShowAllShoppingCartsAction implements MenuAction{

    private final ShoppingCartService shoppingCartService;

    public ShowAllShoppingCartsAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void execute() {
        shoppingCartService.showAllShoppingCarts();
    }

    @Override
    public String getMenuActionName() {
        return "Show all shopping carts";
    }
}
