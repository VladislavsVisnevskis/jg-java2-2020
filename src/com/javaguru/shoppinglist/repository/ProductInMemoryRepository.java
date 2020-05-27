package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public class ProductInMemoryRepository implements ProductRepository<Product>{

    private Map<Long,Product> repository;
    private long productIdSequence = 0L;

    public ProductInMemoryRepository(Map<Long, Product> repository){
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        product.setId(productIdSequence++);
        repository.put(product.getId(), product);
        return product;
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
    public Optional<Product> findProductById(long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public Map<Long, Product> findAllProducts() {
        return repository;
    }
}
