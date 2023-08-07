package com.decimal.springsecurity.rest.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProduct {
    @NotEmpty(message = "Product title cannot be empty")
    private String title;
    private String description;
    @DecimalMin(value = "0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;
    @DecimalMin(value = "0", inclusive = false, message = "Stock must be greater than 0")
    private BigDecimal stock;

}
