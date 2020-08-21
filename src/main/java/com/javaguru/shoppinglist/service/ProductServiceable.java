package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;

public interface ProductServiceable {

    public ProductDto saveProduct(ProductDto productDto);

    public void deleteProduct(long id);

    public void editProduct(long id, String name, BigDecimal price, BigDecimal discount, String description);

    public ProductDto findProductByID(long id);

    public void showAllProducts();
}
