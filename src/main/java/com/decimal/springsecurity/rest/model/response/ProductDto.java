package com.decimal.springsecurity.rest.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto extends AuditDto{
    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    private BigDecimal stock;
}
