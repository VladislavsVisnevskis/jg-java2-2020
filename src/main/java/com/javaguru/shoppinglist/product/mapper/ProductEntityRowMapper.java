package com.javaguru.shoppinglist.product.mapper;

import com.javaguru.shoppinglist.product.domain.ProductCategory;
import com.javaguru.shoppinglist.product.domain.ProductEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductEntityRowMapper implements RowMapper<ProductEntity> {

    @Override
    public ProductEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(resultSet.getLong("id"));
        productEntity.setName(resultSet.getString("name"));
        productEntity.setPrice(resultSet.getBigDecimal("price"));
        productEntity.setCategory(ProductCategory.valueOf(((resultSet.getString("category")).toUpperCase())));
        productEntity.setDiscount(resultSet.getBigDecimal("discount"));
        productEntity.setDescription(resultSet.getString("description"));
        return productEntity;
    }
}
