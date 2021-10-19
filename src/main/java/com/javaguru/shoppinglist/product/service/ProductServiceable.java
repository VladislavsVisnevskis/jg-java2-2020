package com.javaguru.shoppinglist.product.service;

import com.javaguru.shoppinglist.product.dto.ProductDto;

import java.math.BigDecimal;

public interface ProductServiceable {

    public ProductDto saveProduct(ProductDto productDto);

    public void deleteProduct(long id);

    public void editProduct(long id, String name, BigDecimal price, BigDecimal discount, String description);

    public ProductDto findProductByID(long id);

    public void showAllProducts();
}
