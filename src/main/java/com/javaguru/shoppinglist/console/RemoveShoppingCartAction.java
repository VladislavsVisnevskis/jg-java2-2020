package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.shoppingcart.service.ShoppingCartService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(9)
public class RemoveShoppingCartAction implements MenuAction{

    private final ShoppingCartService shoppingCartService;

    public RemoveShoppingCartAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        shoppingCartService.deleteShoppingCart(id);
    }

    @Override
    public String getMenuActionName() {
        return "Remove Shopping cart";
    }
}
