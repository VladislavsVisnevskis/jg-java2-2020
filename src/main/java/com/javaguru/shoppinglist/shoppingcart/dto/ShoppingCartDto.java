package com.javaguru.shoppinglist.shoppingcart.dto;

import com.javaguru.shoppinglist.product.domain.ProductEntity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;


public class ShoppingCartDto {

    private long id;
    private String name;
    private Set<ProductEntity> productSet;
    private BigDecimal cartTotal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductEntity> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<ProductEntity> productSet) {
        this.productSet = productSet;
    }

    public BigDecimal getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(BigDecimal cartTotal) {
        this.cartTotal = cartTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCartDto)) return false;
        ShoppingCartDto that = (ShoppingCartDto) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getProductSet(), that.getProductSet()) &&
                Objects.equals(getCartTotal(), that.getCartTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getProductSet(), getCartTotal());
    }

    @Override
    public String toString() {
        return "ShoppingCartDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productSet=" + productSet +
                ", cartTotal=" + cartTotal +
                '}';
    }
}
