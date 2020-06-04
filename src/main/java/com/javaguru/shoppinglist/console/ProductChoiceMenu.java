package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ProductCategory;

public class ProductChoiceMenu {

    public void showProductCategories(){
        System.out.println("Enter product category: ");
        for (ProductCategory productCategory : ProductCategory.values()){
            System.out.println((productCategory.ordinal() + 1) + ". " + productCategory.toString());
        }
    }

    public ProductCategory productCategoryChoice(int choice){
        ProductCategory category = switch (choice) {
            case 1 -> ProductCategory.VEGETABLES;
            case 2 -> ProductCategory.FRUITS;
            case 3 -> ProductCategory.MEAT;
            case 4 -> ProductCategory.FISH;
            case 5 -> ProductCategory.SWEETS;
            case 6 -> ProductCategory.BAKERY;
            case 7 -> ProductCategory.BEVERAGE;
            case 8 -> ProductCategory.ALCOHOL;
            case 9 -> ProductCategory.MILK;
            case 10 -> ProductCategory.SAUCES;
            case 11 -> ProductCategory.HOUSE;
            case 12 -> ProductCategory.FROZEN;
            case 13 -> ProductCategory.CEREALS;
            default -> ProductCategory.OTHER;
        };
        return category;
    }
}
