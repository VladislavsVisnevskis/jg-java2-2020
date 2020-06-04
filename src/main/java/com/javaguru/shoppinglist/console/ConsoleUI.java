package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ProductCategory;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductServiceable;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {

    private final ProductServiceable productService;
    private final EditMenu editMenu;
    private final ProductChoiceMenu productChoiceMenu;

    public ConsoleUI(ProductServiceable productService, EditMenu editMenu, ProductChoiceMenu productChoiceMenu) {
        this.productService = productService;
        this.editMenu = editMenu;
        this.productChoiceMenu = productChoiceMenu;
    }

    public void execute(){
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. Create product");
                System.out.println("2. Show all products");
                System.out.println("3. Find product by id");
                System.out.println("4. Edit product");
                System.out.println("5. Remove product");
                System.out.println("6. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        productChoiceMenu.showProductCategories();
                        Integer userInputInnerOne = Integer.valueOf(scanner.nextLine());
                        ProductCategory category = productChoiceMenu.productCategoryChoice(userInputInnerOne);

                        System.out.println("Enter product discount: ");
                        BigDecimal discount = new BigDecimal(scanner.nextLine());
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();
                        ProductDto productDto = new ProductDto();
                        productDto.setName(name);
                        productDto.setPrice(price);
                        productDto.setCategory(category);
                        productDto.setDiscount(discount);
                        productDto.setDescription(description);
                        ProductDto savedProduct = productService.saveProduct(productDto);
                        System.out.println("Result: " + savedProduct);
                        break;
                    case 2:
                        productService.showAllProducts();
                        break;
                    case 3:
                        System.out.println("Enter product id: ");
                        try {
                            long id = scanner.nextLong();
                            System.out.println(productService.findProductByID(id));
                        }
                        catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        editMenu.showEditMenu(productService);
                        break;
                    case 5:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        productService.deleteProduct(id);
                        break;
                    case 6:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
