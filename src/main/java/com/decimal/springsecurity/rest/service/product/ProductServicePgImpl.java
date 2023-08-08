package com.decimal.springsecurity.rest.service.product;

import com.decimal.springsecurity.rest.model.entity.Product;
import com.decimal.springsecurity.rest.model.mapper.ProductMapper;
import com.decimal.springsecurity.rest.model.request.AddProduct;
import com.decimal.springsecurity.rest.model.response.ProductDto;
import com.decimal.springsecurity.rest.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServicePgImpl implements ProductService {

    private static final ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);
    private final ProductRepository productRepository;

    @Override
    public ProductDto gitById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("Not product found for id %s", id)
                ));
        return PRODUCT_MAPPER.entityToDto(product);
    }

    @Override
    public ProductDto addProduct(AddProduct productRequest) {
        Product product = productRepository.save(
                PRODUCT_MAPPER.addProductRequestToEntity(productRequest)
        );
        return PRODUCT_MAPPER.entityToDto(product);
    }
}
