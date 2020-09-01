package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.product.service.ProductServiceable;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
@Order(4)
public class EditProductAction implements MenuAction {

    private final ProductServiceable productService;

    public EditProductAction(ProductServiceable productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product id: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Enter product new name or \"Enter\" to skip: ");
        String newName = scanner.nextLine();

        System.out.println("Enter product new price or \"Enter\" to skip: ");
        BigDecimal newPrice = null;
        String scannerInput = scanner.nextLine();
        if (scannerInput.matches("^([0-9]+\\.?[0-9]*|[0-9]*\\.[0-9]+)$")) {
            newPrice = new BigDecimal(scannerInput);
        }

        System.out.println("Enter product new discount (0-100) or \"Enter\" to skip: ");
        BigDecimal newDiscount = null;
        String scannerInputNext = scanner.nextLine();
        if (scannerInputNext.matches("^([0-9]+\\.?[0-9]*|[0-9]*\\.[0-9]+)$")) {
            newDiscount = new BigDecimal(scannerInputNext);
        }

        System.out.println("Enter product new description or \"Enter\" to skip: ");
        String newDescription = scanner.nextLine();

        productService.editProduct(id, newName, newPrice, newDiscount, newDescription);
    }

    @Override
    public String getMenuActionName() {
        return "Edit product";
    }
}
