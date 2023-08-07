package com.decimal.springsecurity.rest.model.mapper;

import com.decimal.springsecurity.rest.model.entity.Customer;
import com.decimal.springsecurity.rest.model.request.AddCustomer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer addRequestToEntity(AddCustomer addCustomer);
}
