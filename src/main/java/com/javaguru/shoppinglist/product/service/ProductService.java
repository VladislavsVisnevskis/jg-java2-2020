package com.javaguru.shoppinglist.product.service;

import com.javaguru.shoppinglist.product.domain.ProductEntity;
import com.javaguru.shoppinglist.product.dto.ProductDto;
import com.javaguru.shoppinglist.product.mapper.ProductMapper;
import com.javaguru.shoppinglist.product.repository.ProductRepository;
import com.javaguru.shoppinglist.product.service.validation.ProductValidationService;
import com.javaguru.shoppinglist.shoppingcart.domain.ShoppingCartEntity;
import com.javaguru.shoppinglist.shoppingcart.repository.ShoppingCartRepository;
import com.javaguru.shoppinglist.shoppingcart.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService implements ProductServiceable {

    private final ProductRepository<ProductEntity> productRepository;
    private final ProductValidationService productValidationService;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository<ProductEntity> productRepository,
                          ProductValidationService productValidationService,
                          ProductMapper productMapper) {
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
    public void editProduct(long id, String name, BigDecimal price, BigDecimal discount, String description) {
        ProductDto productDto = findProductByID(id);
        productDto.setId(id);
        if (!name.equals("")) {
            productDto.setName(name);
        }
        if (price != null) {
            productDto.setPrice(price);
        }
        if (discount != null) {
            productDto.setDiscount(discount);
        }
        if (!description.equals("")) {
            productDto.setDescription(description);
        }
        List<String> errorList = productValidationService.validate(productDto);
        if (!errorList.isEmpty()) {
            throw new IllegalArgumentException("Incorrect input:" + '\n' + errorList);
        } else {
            productRepository.editProduct(productMapper.toEntity(productDto));
        }
    }

    @Override
    public ProductDto findProductByID(long id) {
        return productMapper.toDto(productRepository.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID: " + id + " is not found")));
    }

    @Override
    public void showAllProducts() {
        productRepository.findAllProducts().forEach((product) -> System.out.println(productMapper.toDto(product)));
    }
}
