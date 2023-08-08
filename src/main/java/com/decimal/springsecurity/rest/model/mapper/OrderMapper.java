package com.decimal.springsecurity.rest.model.mapper;

import com.decimal.springsecurity.rest.model.entity.Order;
import com.decimal.springsecurity.rest.model.entity.Product;
import com.decimal.springsecurity.rest.model.request.AddOrder;
import com.decimal.springsecurity.rest.model.response.OrderDto;
import com.decimal.springsecurity.rest.model.response.ProductDto;
import com.decimal.springsecurity.rest.util.DateUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = {
        DateUtil.class
})
public interface OrderMapper {
    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);
    Order orderFromRequest(AddOrder request);

    @Mapping(target = "createdAt", expression = "java(DateUtil.epochToLocalDateTime(order.getCreatedAt()))")
    @Mapping(target = "updatedAt", expression = "java(DateUtil.epochToLocalDateTime(order.getUpdatedAt()))")
    @Mapping(target = "products", expression = "java(mapOrderProducts(order.getProducts()))")
    OrderDto entityToDto(Order order);

    default List<ProductDto> mapOrderProducts(List<Product> products) {
        return products.stream().map(
                PRODUCT_MAPPER::entityToDto
        ).collect(Collectors.toList());
    }
}
