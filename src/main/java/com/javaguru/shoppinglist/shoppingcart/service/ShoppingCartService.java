package com.javaguru.shoppinglist.shoppingcart.service;

import com.javaguru.shoppinglist.product.domain.ProductEntity;
import com.javaguru.shoppinglist.product.mapper.ProductMapper;
import com.javaguru.shoppinglist.product.service.ProductService;
import com.javaguru.shoppinglist.shoppingcart.domain.ShoppingCartEntity;
import com.javaguru.shoppinglist.shoppingcart.dto.ShoppingCartDto;
import com.javaguru.shoppinglist.shoppingcart.mapper.ShoppingCartMapper;
import com.javaguru.shoppinglist.shoppingcart.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    private final ShoppingCartMapper shoppingCartMapper;
    private final ShoppingCartRepository<ShoppingCartEntity> shoppingCartRepository;
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ShoppingCartService(ShoppingCartMapper shoppingCartMapper,
                               ShoppingCartRepository<ShoppingCartEntity> shoppingCartRepository,
                               ProductService productService,
                               ProductMapper productMapper) {
        this.shoppingCartMapper = shoppingCartMapper;
        this.shoppingCartRepository = shoppingCartRepository;
        this.productService = productService;
        this.productMapper = productMapper;
    }

    public ShoppingCartDto save(ShoppingCartDto shoppingCartDto){
        ShoppingCartEntity entity = shoppingCartRepository.save(shoppingCartMapper.toEntity(shoppingCartDto));
        return shoppingCartMapper.toDto(entity);
    }

    public void deleteShoppingCart(long id) {
        if (shoppingCartRepository.findById(id) == null) {
            throw new IllegalArgumentException("Shopping cart with ID: " + id + " is not found");
        } else {
            shoppingCartRepository.deleteShoppingCart(id);
        }
    }

    public ShoppingCartDto findShoppingCartById(long id){
        return shoppingCartMapper.toDto(shoppingCartRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Shopping cart with ID: " + id + " is not found")));
    }

    public void showAllShoppingCarts() {
        shoppingCartRepository.findAllShoppingCarts().
                forEach((shoppingCart) -> System.out.println(shoppingCartMapper.toDto(shoppingCart)));
    }


    public void assingProductToShoppingCart(long shoppingCartId ,long productId){
        ShoppingCartEntity shoppingCartEntity = shoppingCartRepository.findById(shoppingCartId).
                orElseThrow(() -> new IllegalArgumentException("Shopping cart with ID: " + shoppingCartId + " is not found"));
        ProductEntity productEntity = productMapper.toEntity(productService.findProductByID(productId));
        shoppingCartEntity.addProductToShoppingCart(productEntity);
        update(shoppingCartEntity);
    }

    public void update(ShoppingCartEntity shoppingCartEntity){
        shoppingCartRepository.update(shoppingCartEntity);
    }
}
