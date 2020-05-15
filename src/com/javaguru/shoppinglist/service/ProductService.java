package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ProductService<T> {

    public void addProduct(T item) throws ProductValidationException;

    public void deleteProduct(long ID);

    public void editProductName(long ID, String name);

    public void editProductPrice(long ID, BigDecimal price);

    public void editProductDiscount(long ID, BigDecimal discount);

    public void editProductDescription(long ID, String description);

    public Product findProductByID(long ID);

    public void showAllProducts();
}
