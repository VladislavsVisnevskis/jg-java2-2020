package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ProductCategory;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
@Order(1)
public class CreateProductAction implements MenuAction{

    private final ProductService productService;
    private final ProductChoiceMenu productChoiceMenu;

    public CreateProductAction(ProductService productService, ProductChoiceMenu productChoiceMenu) {
        this.productService = productService;
        this.productChoiceMenu = productChoiceMenu;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

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
    }

    @Override
    public String getMenuActionName() {
        return "Create product";
    }
}

