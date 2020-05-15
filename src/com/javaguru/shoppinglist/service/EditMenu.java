package com.javaguru.shoppinglist.service;

import java.math.BigDecimal;
import java.util.Scanner;

public class EditMenu {
    public static void showEditMenu(ProductService productService){
        Scanner scannerTwo = new Scanner(System.in);
        System.out.println("1. Edit name");
        System.out.println("2. Edit price");
        System.out.println("3. Edit discount");
        System.out.println("4. Edit description");
        System.out.println("5. Return");
        Integer userInputInnerTwo = Integer.valueOf(scannerTwo.nextLine());
        switch (userInputInnerTwo) {
            case 1:
                System.out.println("Enter product id: ");
                long id = Long.parseLong(scannerTwo.nextLine());
                System.out.println("Enter product new name: ");
                String newName = scannerTwo.nextLine();
                productService.editProductName(id, newName);
                break;
            case 2:
                System.out.println("Enter product id: ");
                id = Long.parseLong(scannerTwo.nextLine());
                System.out.println("Enter product new price: ");
                BigDecimal newPrice = new BigDecimal (scannerTwo.nextLine());
                productService.editProductPrice(id, newPrice);
                break;
            case 3:
                System.out.println("Enter product id: ");
                id = Long.parseLong(scannerTwo.nextLine());
                System.out.println("Enter product new discount (0-100): ");
                BigDecimal newDiscount = new BigDecimal (scannerTwo.nextLine());
                productService.editProductDiscount(id, newDiscount);
                                break;
            case 4:
                System.out.println("Enter product id: ");
                id = Long.parseLong(scannerTwo.nextLine());
                System.out.println("Enter product new description: ");
                String newDescription = scannerTwo.nextLine();
                productService.editProductDescription(id, newDescription);
                break;
            case 5:
                break;
        }
    }
}
