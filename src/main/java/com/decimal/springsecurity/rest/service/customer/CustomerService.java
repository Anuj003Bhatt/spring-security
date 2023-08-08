package com.decimal.springsecurity.rest.service.customer;

import com.decimal.springsecurity.rest.model.request.AddCustomer;
import com.decimal.springsecurity.rest.model.response.CustomerDto;

public interface CustomerService {
    CustomerDto addCustomer(AddCustomer addCustomer);
}
