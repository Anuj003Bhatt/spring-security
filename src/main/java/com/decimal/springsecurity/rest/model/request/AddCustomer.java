package com.decimal.springsecurity.rest.model.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddCustomer {
    @Size(min = 3, max = 255, message = "Name should be of 3-255 characters")
    private String name;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
//    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$")
    private String phone;
    private String password;
    private AddAddress address;
}
