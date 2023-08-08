package com.decimal.springsecurity.rest.controller;

import com.decimal.springsecurity.rest.model.request.AddCustomer;
import com.decimal.springsecurity.rest.model.response.CustomerDto;
import com.decimal.springsecurity.rest.service.customer.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto addCustomer(@RequestBody @Valid AddCustomer addCustomer) {
        return customerService.addCustomer(addCustomer);
    }
}
