package com.javaguru.shoppinglist.shoppingcart.domain;

import com.javaguru.shoppinglist.product.domain.ProductEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "shopping_cart_product",
            joinColumns = { @JoinColumn(name = "shopping_cart_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
            )
    private Set<ProductEntity> productSet;

    public void addProductToShoppingCart(ProductEntity productEntity){
        productSet.add(productEntity);
    }

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

    public Set<ProductEntity> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<ProductEntity> productSet) {
        this.productSet = productSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCartEntity)) return false;
        ShoppingCartEntity that = (ShoppingCartEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getProductSet(), that.getProductSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getProductSet());
    }

    @Override
    public String toString() {
        return "ShoppingCartEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productSet=" + productSet +
                '}';
    }
}

