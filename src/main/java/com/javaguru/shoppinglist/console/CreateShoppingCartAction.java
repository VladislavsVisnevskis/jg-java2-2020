package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.product.domain.ProductCategory;
import com.javaguru.shoppinglist.product.dto.ProductDto;
import com.javaguru.shoppinglist.shoppingcart.dto.ShoppingCartDto;
import com.javaguru.shoppinglist.shoppingcart.service.ShoppingCartService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
@Order(6)
public class CreateShoppingCartAction implements MenuAction {

    private final ShoppingCartService shoppingCartService;

    public CreateShoppingCartAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shopping cart name: ");
        String name = scanner.nextLine();
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        shoppingCartDto.setName(name);
        System.out.println(shoppingCartDto);
        ShoppingCartDto savedShoppingCart = shoppingCartService.save(shoppingCartDto);
        System.out.println("Result: " + savedShoppingCart);
    }

    @Override
    public String getMenuActionName() {
        return "Create shopping cart";
    }
}
