package com.javaguru.shoppinglist.product.repository;

import com.javaguru.shoppinglist.product.domain.ProductEntity;
import com.javaguru.shoppinglist.product.mapper.ProductEntityRowMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("mysql")
public class DatabaseRepository implements ProductRepository<ProductEntity> {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        String query = "INSERT INTO product (name, price, category, discount, description) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, productEntity.getName());
            preparedStatement.setBigDecimal(2, productEntity.getPrice());
            preparedStatement.setString(3, productEntity.getCategory().toString());
            preparedStatement.setBigDecimal(4, productEntity.getDiscount());
            preparedStatement.setString(5, productEntity.getDescription());
            return preparedStatement;
        }, keyHolder);
        productEntity.setId(keyHolder.getKey().longValue());
        return productEntity;
    }

    @Override
    public void remove(long id) {
        String query = "DELETE FROM product WHERE id = ?";
        jdbcTemplate.update(query, id);
        System.out.println("Deleted product with ID = " + id);
    }

    @Override
    public void editProduct(ProductEntity productEntity) {
        String updateQuery = "UPDATE product " +
                "SET name = ? , " +
                "price = ? , " +
                "category = ? , " +
                "discount = ? , " +
                "description = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(updateQuery,
                productEntity.getName(),
                productEntity.getPrice(),
                productEntity.getCategory().toString(),
                productEntity.getDiscount(),
                productEntity.getDescription(),
                productEntity.getId());
        System.out.println("Product with ID = " + productEntity.getId() + " has been updated");
    }

    @Override
    public Optional findProductById(long id) {
        String query = "SELECT * FROM product WHERE id = ?";
        ProductEntity productEntity = jdbcTemplate.queryForObject(query, new Object[]{id}, new ProductEntityRowMapper());
        return Optional.ofNullable(productEntity);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        String query = "SELECT * FROM product";
        List<ProductEntity> entityList = jdbcTemplate.query(query, new ProductEntityRowMapper());
        return entityList;
    }
}
