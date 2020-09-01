package com.javaguru.shoppinglist.product.repository;

import com.javaguru.shoppinglist.product.domain.ProductEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Profile("inmemory")
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
    public void editProduct(ProductEntity productEntity) {
        repository.put(productEntity.getId(), productEntity);
    }

    @Override
    public Optional<ProductEntity> findProductById(long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return (List<ProductEntity>) repository.values();
    }
}
