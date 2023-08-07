package com.decimal.springsecurity.rest.model.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class OrderDto {
    private UUID id;
    private BigDecimal quantity;
    List<ProductDto> products;
}
