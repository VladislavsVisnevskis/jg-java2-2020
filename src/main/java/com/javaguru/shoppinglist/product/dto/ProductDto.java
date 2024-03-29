package com.javaguru.shoppinglist.product.dto;

import com.javaguru.shoppinglist.product.domain.ProductCategory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal discount;
    private ProductCategory category;
    private String description;
    private BigDecimal actualPrice;

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

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto)) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getDiscount(), that.getDiscount()) &&
                getCategory() == that.getCategory() &&
                Objects.equals(getDescription(), that.getDescription());
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
                ", actualPrice=" + actualPrice.setScale(2, RoundingMode.CEILING) +
                ", discount=" + discount + "%" +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }
}
