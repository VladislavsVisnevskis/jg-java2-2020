package com.javaguru.shoppinglist.repository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public interface ProductRepository<Product> {

    Product save(Product product);

    void remove(long id);

    void editName(long id, String name);

    void editPrice(long id, BigDecimal price);

    void editDiscount(long id, BigDecimal discount);

    void editDescription(long id, String description);

    Optional<Product> findProductById(long id);

    Map<Long, Product> findAllProducts();
}
