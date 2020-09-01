package com.javaguru.shoppinglist.shoppingcart.repository;

import com.javaguru.shoppinglist.shoppingcart.domain.ShoppingCartEntity;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository<Cart> {

    Cart save(Cart shoppingCart);

    void deleteShoppingCart(long id);

    void editShoppingCart(Cart shoppingCart);

    Optional<Cart> findById(long id);

    List<Cart> findAllShoppingCarts();

    void update(ShoppingCartEntity shoppingCartEntity);
}
