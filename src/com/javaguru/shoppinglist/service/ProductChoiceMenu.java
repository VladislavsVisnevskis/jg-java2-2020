package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.ProductCategory;

public class ProductChoiceMenu {

    public static void showProductCategories(){
        System.out.println("Enter product category: ");
        System.out.println("1. Vegetables");
        System.out.println("2. Fruits");
        System.out.println("3. Meat");
        System.out.println("4. Fish");
        System.out.println("5. Sweets");
        System.out.println("6. Bakery");
        System.out.println("7. Beverage");
        System.out.println("8. Alcohol");
        System.out.println("9. Milk");
        System.out.println("10. Other");
    }

    public static ProductCategory productCategoryChoice(int choice){
        ProductCategory category;
        switch (choice) {
            case 1:
                category = ProductCategory.VEGETABLES;
                break;
            case 2:
                category = ProductCategory.FRUITS;
                break;
            case 3:
                category = ProductCategory.MEAT;
                break;
            case 4:
                category = ProductCategory.FISH;
                break;
            case 5:
                category = ProductCategory.SWEETS;
                break;
            case 6:
                category = ProductCategory.BAKERY;
                break;
            case 7:
                category = ProductCategory.BEVERAGE;
                break;
            case 8:
                category = ProductCategory.ALCOHOL;
                break;
            case 9:
                category = ProductCategory.MILK;
                break;
            default:
                category = ProductCategory.OTHER;
                }
        return category;
    }
}
