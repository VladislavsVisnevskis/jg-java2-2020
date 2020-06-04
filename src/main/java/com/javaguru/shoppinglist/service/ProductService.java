package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mapper.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;
import java.util.List;

public class ProductService implements ProductServiceable {

    private final ProductRepository<ProductEntity> productRepository;
    private final ProductValidationService productValidationService;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository<ProductEntity> productRepository, ProductValidationService productValidationService, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productValidationService = productValidationService;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        List<String> errorList = productValidationService.validate(productDto);
        if (!errorList.isEmpty()) {
            throw new IllegalArgumentException("Incorrect input:" + '\n' + errorList);
        } else {
            ProductEntity entity = productRepository.save(productMapper.toEntity(productDto));
            return productMapper.toDto(entity);
        }
    }


    @Override
    public void deleteProduct(long id) {
        if (productRepository.findProductById(id) == null) {
            throw new IllegalArgumentException("Product with ID: " + id + " is not found");
        }
        else {
            productRepository.remove(id);
        }
    }

    @Override
    public void editProductName(long id, String name) {
        if (!name.matches("[A-Za-z0-9]+") || name.length() < 3 || name.length() > 32) {
            throw new ProductValidationException("Product name is invalid - only letters and numbers are allowed" + '\n' + "Minimal Length 3 and maximal 32 characters");
        }
        else {
            productRepository.editName(id, name);
        }
    }

    @Override
    public void editProductPrice(long id, BigDecimal price) {
        if ((price.compareTo(BigDecimal.valueOf(0)) < 0)) {
            throw new ProductValidationException("Product price is invalid");
        }
        else {
            productRepository.editPrice(id, price);
        }
    }

    @Override
    public void editProductDiscount(long id, BigDecimal discount) {
        if (discount == null || discount.equals("")){
            throw new IllegalArgumentException("Please, enter the discount value");
        }

        if ((discount.compareTo(BigDecimal.valueOf(0)) < 0) || (discount.compareTo(BigDecimal.valueOf(100))) > 0) {
            throw new ProductValidationException("Product discount is invalid");
        }

        ProductDto foundProduct = productMapper.toDto(productRepository.findProductById(id)
        .orElseThrow(() -> new IllegalArgumentException("Product with ID: " + id + " is not found")));

        if ((foundProduct.getPrice().compareTo(BigDecimal.valueOf(20L)) <= 0) || (foundProduct.getDiscount().compareTo(BigDecimal.valueOf(0)) > 0)){
            throw new ProductValidationException("Products with price 20$ or lower are not applicable with discount");
        }

        productRepository.editDiscount(id, discount);
    }

    @Override
    public void editProductDescription(long id, String description) {
        productRepository.editDescription(id, description);
    }

    @Override
    public ProductDto findProductByID(long id) {
        return productMapper.toDto(productRepository.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID: " + id + " is not found")));
    }

    @Override
    public void showAllProducts() {
//        productRepository.findAllProducts().values()
//                .stream()
//                .forEach(System.out::println);
        productRepository.findAllProducts().values().forEach((product) -> System.out.println(productMapper.toDto(product)));
    }

}
