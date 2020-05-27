package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductServiceable<Product> {

    public Product saveProduct(Product product);

    public void deleteProduct(long id);

    public void editProductName(long id, String name);

    public void editProductPrice(long id, BigDecimal price);

    public void editProductDiscount(long id, BigDecimal discount);

    public void editProductDescription(long id, String description);

    public Product findProductByID(long id);

    public void showAllProducts();
}
