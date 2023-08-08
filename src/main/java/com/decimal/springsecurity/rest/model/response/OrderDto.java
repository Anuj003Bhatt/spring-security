package com.decimal.springsecurity.rest.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDto extends AuditDto{
    private UUID id;
    private BigDecimal quantity;
    private List<ProductDto> products;
}
