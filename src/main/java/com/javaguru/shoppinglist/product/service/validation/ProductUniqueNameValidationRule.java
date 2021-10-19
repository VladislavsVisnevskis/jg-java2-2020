//package com.javaguru.shoppinglist.service.validation;
//
//import com.javaguru.shoppinglist.domain.ProductEntity;
//import com.javaguru.shoppinglist.dto.ProductDto;
//import com.javaguru.shoppinglist.repository.ProductRepository;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProductUniqueNameValidationRule implements ProductValidationRule<ProductDto>{
//
//    private final ProductRepository<ProductEntity> productRepository;
//
//    public ProductUniqueNameValidationRule(ProductRepository<ProductEntity> productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @Override
//    public void validate(ProductDto productDto) throws ProductValidationException {
//        if(productRepository.findAllProducts().stream()
//                .anyMatch(stock -> stock.getName().equals(productDto.getName()))){
//            throw new ProductValidationException ("Product with such name already exists");
//        }
//    }
//}
//
