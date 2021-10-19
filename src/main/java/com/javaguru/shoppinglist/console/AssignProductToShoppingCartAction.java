package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.product.service.ProductService;
import com.javaguru.shoppinglist.shoppingcart.service.ShoppingCartService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(10)
public class AssignProductToShoppingCartAction implements MenuAction {

    private final ShoppingCartService shoppingCartService;

    public AssignProductToShoppingCartAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Product ID");
        long productId = Long.parseLong(scanner.next());
        System.out.println("Enter Shopping cart ID");
        long shoppingCartId = Long.parseLong(scanner.next());
        shoppingCartService.assingProductToShoppingCart(shoppingCartId, productId);
    }

    @Override
    public String getMenuActionName() {
        return "Assign Product to Shopping cart";
    }
}
