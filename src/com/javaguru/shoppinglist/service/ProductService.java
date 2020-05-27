package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductUniqueNameValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;

public class ProductService implements ProductServiceable<Product> {

    private ProductRepository<Product> productRepository;
    private ProductValidationService productValidationService = new ProductValidationService();
    private ProductUniqueNameValidationRule productUniqueNameValidationRule = new ProductUniqueNameValidationRule();

    public ProductService(ProductRepository<Product> productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        productUniqueNameValidationRule.validate(product, productRepository);
        productValidationService.validate(product);
        if (!productValidationService.validate(product).isEmpty()) {
            throw new IllegalArgumentException("Incorrect input:" + '\n' + productValidationService.validate(product));
        } else {
            Product createdProduct = productRepository.save(product);
            return createdProduct;
        }
    }


    @Override
    public void deleteProduct(long id) {
        if (productRepository.findProductById(id) != null) {
            productRepository.remove(id);
        }
        else {
            throw new IllegalArgumentException("Product with ID: " + id + " is not found");
        }
    }

    @Override
    public void editProductName(long id, String name) {
        productRepository.editName(id, name);
    }

    @Override
    public void editProductPrice(long id, BigDecimal price) {
        productRepository.editPrice(id, price);
    }

    @Override
    public void editProductDiscount(long id, BigDecimal discount) {
        productRepository.editDiscount(id, discount);
    }

    @Override
    public void editProductDescription(long id, String description) {
        productRepository.editDescription(id, description);
    }

    @Override
    public Product findProductByID(long id) {
        return productRepository.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID: " + id + " is not found"));
    }

    @Override
    public void showAllProducts() {
        productRepository.findAllProducts().entrySet()
                .stream()
                .forEach(System.out::println);
    }
}
