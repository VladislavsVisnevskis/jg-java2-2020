package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.dto.ProductDto;

import java.math.BigDecimal;

public interface ProductServiceable {

    public ProductDto saveProduct(ProductDto productDto);

    public void deleteProduct(long id);

    public void editProductName(long id, String name);

    public void editProductPrice(long id, BigDecimal price);

    public void editProductDiscount(long id, BigDecimal discount);

    public void editProductDescription(long id, String description);

    public ProductDto findProductByID(long id);

    public void showAllProducts();
}
