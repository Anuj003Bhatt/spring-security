package com.decimal.springsecurity.rest.model.request;

import jakarta.validation.constraints.DecimalMin;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AddOrder {
    private UUID orderId;
    private UUID productId;
    @DecimalMin(value = "0", inclusive = false)
    private BigDecimal quantity;
}
