package com.decimal.springsecurity.rest.model.mapper;

import com.decimal.springsecurity.rest.model.entity.Order;
import com.decimal.springsecurity.rest.model.request.AddOrder;
import com.decimal.springsecurity.rest.model.response.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {

    Order orderFromRequest(AddOrder request);

    OrderDto entityToDto(Order order);
}
