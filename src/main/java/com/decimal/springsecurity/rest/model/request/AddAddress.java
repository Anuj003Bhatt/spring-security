package com.decimal.springsecurity.rest.model.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddAddress {
    @Size(min = 3, max = 255, message = "Address must be 3-255 characters long")
    private String streetAddress;
    @Size(min = 3, max = 255, message = "Invalid postal code")
    private String postalCode;
    @Size(min = 3, max = 255, message = "Invalid country")
    private String country;
}
