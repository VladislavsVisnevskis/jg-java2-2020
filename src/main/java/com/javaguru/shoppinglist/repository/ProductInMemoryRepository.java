package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ProductEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductInMemoryRepository implements ProductRepository<ProductEntity>{

    private Map<Long, ProductEntity> repository = new HashMap<>();
    private long productIdSequence = 0L;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        productEntity.setId(productIdSequence++);
        repository.put(productEntity.getId(), productEntity);
        return productEntity;
    }

    @Override
    public void remove(long id) {
        repository.remove(id);
    }

    @Override
    public void editName(long id, String name) {
        repository.get(id).setName(name);
    }

    @Override
    public void editPrice(long id, BigDecimal price) {
        repository.get(id).setPrice(price);
    }

    @Override
    public void editDiscount(long id, BigDecimal discount) {
        repository.get(id).setDiscount(discount);
    }

    @Override
    public void editDescription(long id, String description) {
        repository.get(id).setDescription(description);
    }

    @Override
    public Optional<ProductEntity> findProductById(long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public Map<Long, ProductEntity> findAllProducts() {
        return repository;
    }
}
