package com.decimal.springsecurity.rest.model.mapper;

import com.decimal.springsecurity.rest.model.entity.Product;
import com.decimal.springsecurity.rest.model.request.AddProduct;
import com.decimal.springsecurity.rest.model.response.ProductDto;
import com.decimal.springsecurity.rest.util.DateUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {
        DateUtil.class
})
public interface ProductMapper {
    Product addProductRequestToEntity(AddProduct productRequest);

    @Mapping(target = "createdAt", expression = "java(DateUtil.epochToLocalDateTime(product.getCreatedAt()))")
    @Mapping(target = "updatedAt", expression = "java(DateUtil.epochToLocalDateTime(product.getUpdatedAt()))")
    ProductDto entityToDto(Product product);
}
