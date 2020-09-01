package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.shoppingcart.service.ShoppingCartService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(8)
public class FindShoppingCartByIdAction implements MenuAction{

    private final ShoppingCartService shoppingCartService;

    public FindShoppingCartByIdAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Shopping cart ID: ");
        try {
            long id = scanner.nextLong();
            System.out.println(shoppingCartService.findShoppingCartById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getMenuActionName() {
        return "Find Shopping cart by ID";
    }
}
