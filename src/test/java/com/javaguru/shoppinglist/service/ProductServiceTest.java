package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductCategory;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mapper.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest{

    @Mock
    private ProductRepository repository;
    @Mock
    private ProductValidationService validationService;
    @Spy
    private ProductMapper mapper;

    @InjectMocks
    private ProductService victim;

    @Test
    public void shouldSaveProduct(){
        when(repository.save(any())).thenReturn(entity());
        when(mapper.toDto((entity()))).thenReturn(dto());

        ProductDto dto = victim.saveProduct(dto());
        verify(validationService).validate(any());
        assertEquals(dto(), dto);
    }

    @Test
    public void shouldFindProduct(){
        Mockito.<Optional<ProductEntity>>when(repository.findProductById(2L)).thenReturn((Optional.of(entity())));
        when(mapper.toDto((entity()))).thenReturn(dto());
        
        ProductDto dto = victim.findProductByID(2L);
        assertEquals(dto, dto());
    }

    @Test
    public void shouldDeleteProduct() {
        Optional<ProductEntity> optionalEntity = Optional.of(entity());
        Mockito.when(repository.findProductById(2L)).thenReturn(optionalEntity);
        
        victim.deleteProduct(entity().getId());
        Mockito.verify(repository, times(1)).remove(entity().getId());
    }

    private ProductDto dto(){
        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("DTO_NAME");
        productDto.setPrice(BigDecimal.valueOf(100));
        productDto.setCategory(ProductCategory.ALCOHOL);
        productDto.setDiscount(BigDecimal.valueOf(0));
        productDto.setDescription("DESCRIPTION");
        return productDto;
    }

    private ProductEntity entity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(2L);
        productEntity.setName("ENTITY_NAME");
        productEntity.setPrice(BigDecimal.valueOf(100));
        productEntity.setCategory(ProductCategory.ALCOHOL);
        productEntity.setDiscount(BigDecimal.valueOf(0));
        productEntity.setDescription("DESCRIPTION");
        return productEntity;
    }
}