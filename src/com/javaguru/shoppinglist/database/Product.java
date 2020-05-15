package com.javaguru.shoppinglist.database;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal discount;
    private BigDecimal actualPrice; //if there is a discount, there should be actual price as well
    private ProductCategory category;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public void setActualPrice(){
        this.actualPrice = price.multiply((BigDecimal.valueOf(100).subtract(discount)).divide(BigDecimal.valueOf(100)));
    }

    public BigDecimal getActualPrice(){
        return actualPrice;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId()) &&
                getName().equals(product.getName()) &&
                getPrice().equals(product.getPrice()) &&
                getDiscount().equals(product.getDiscount()) &&
                getCategory() == product.getCategory() &&
                getDescription().equals(product.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getDiscount(), getCategory(), getDescription());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", actualPrice=" + actualPrice +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }
}