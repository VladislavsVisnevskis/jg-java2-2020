package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(3)
public class FindProductByIdAction implements MenuAction {

    private final ProductService productService;

    public FindProductByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        try {
            long id = scanner.nextLong();
            System.out.println(productService.findProductByID(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getMenuActionName() {
        return "Find product by ID";
    }
}