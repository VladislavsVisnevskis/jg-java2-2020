package com.javaguru.shoppinglist.product.repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository<Product> {

    Product save(Product product);

    void remove(long id);

    void editProduct(Product product);

    Optional<Product> findProductById(long id);

    List<Product> findAllProducts();
}
