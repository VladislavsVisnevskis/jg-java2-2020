package com.javaguru.shoppinglist.product.domain;

public enum ProductCategory {
    VEGETABLES ("Vegetables"),
    FRUITS ("Fruits"),
    MEAT("Meat"),
    FISH("Fish"),
    SWEETS("Sweets"),
    BAKERY("Bakery"),
    BEVERAGE("Beverage"),
    ALCOHOL("Alcohol"),
    MILK("Milk"),
    SAUCES("Sauces"),
    HOUSE("House"),
    FROZEN("Frozen"),
    CEREALS("Cereals"),
    OTHER("Other");

    private String category;

    ProductCategory(String category){
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}
