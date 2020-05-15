package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.Product;
import java.math.BigDecimal;
import java.util.Map;

public class ProductRepository implements ProductService<Product>{

    private Map<Long, Product> productMap;

    public ProductRepository(Map productMap){
        this.productMap = productMap;
    }

    @Override
    public void addProduct(Product product) throws ProductValidationException{
        ProductValidationService.validate(product);
        productMap.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(long ID) {
        productMap.remove(ID);
    }

    @Override
    public void editProductName(long ID, String name) {
        productMap.get(ID).setName(name);
    }

    @Override
    public void editProductPrice(long ID, BigDecimal price) {
        productMap.get(ID).setPrice(price);
    }

    @Override
    public void editProductDiscount(long ID, BigDecimal discount) {
        productMap.get(ID).setDiscount(discount);
        productMap.get(ID).setActualPrice();
    }

    @Override
    public void editProductDescription(long ID, String description) {
        productMap.get(ID).setDescription(description);
    }

    @Override
    public Product findProductByID(long ID) {
        return productMap.get(ID);
    }

    @Override
    public void showAllProducts() {
        productMap.entrySet()
                .stream()
                .forEach(System.out::println);
    }
}
