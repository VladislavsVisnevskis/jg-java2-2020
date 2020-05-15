package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.database.Product;
import com.javaguru.shoppinglist.database.ProductCategory;
import com.javaguru.shoppinglist.service.EditMenu;
import com.javaguru.shoppinglist.service.ProductChoiceMenu;
import com.javaguru.shoppinglist.service.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productMap = new HashMap<>();
        ProductService<Product> productService = new ProductRepository(productMap);
        Long productIdSequence = 0L;
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
                        ProductChoiceMenu.showProductCategories();
                        Integer userInputInnerOne = Integer.valueOf(scanner.nextLine());
                        ProductCategory category = ProductChoiceMenu.productCategoryChoice(userInputInnerOne);
                        System.out.println("Enter product discount: ");
                        BigDecimal discount = new BigDecimal(scanner.nextLine());
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();
                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setCategory(category);
                        product.setDiscount(discount);
                        product.setDescription(description);
                        product.setId(productIdSequence);
                        productService.addProduct(product);
                        productIdSequence++;
                        System.out.println("Result: " + product);
                        break;
                    case 2:
                        productService.showAllProducts();
                        break;
                    case 3:
                        System.out.println("Enter product id: ");
                        try {
                            long id = scanner.nextLong();
                            System.out.println(productService.findProductByID(id));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        EditMenu.showEditMenu(productService);
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
