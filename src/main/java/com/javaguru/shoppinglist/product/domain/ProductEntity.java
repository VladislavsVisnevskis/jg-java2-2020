package com.javaguru.shoppinglist.product.domain;

import com.javaguru.shoppinglist.shoppingcart.domain.ShoppingCartEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "discount")
    private BigDecimal discount;
    @Enumerated(EnumType.STRING)
    @Column(name = "category", columnDefinition="enum")
    private ProductCategory category;
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "productSet", fetch = FetchType.EAGER)
    private Set<ShoppingCartEntity> shoppingCartSet;

    public Set<ShoppingCartEntity> getShoppingCartSet() {
        return shoppingCartSet;
    }

    public void setShoppingCartSet(Set<ShoppingCartEntity> shoppingCartSet) {
        this.shoppingCartSet = shoppingCartSet;
    }

    public void addShoppingCartToProduct(ShoppingCartEntity shoppingCartEntity){
        shoppingCartSet.add(shoppingCartEntity);
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

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getDiscount(), that.getDiscount()) &&
                getCategory() == that.getCategory() &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getShoppingCartSet(), that.getShoppingCartSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getDiscount(), getCategory(), getDescription());
    }
}