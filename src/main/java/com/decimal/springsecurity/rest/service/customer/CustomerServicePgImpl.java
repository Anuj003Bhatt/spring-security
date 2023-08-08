package com.decimal.springsecurity.rest.service.customer;

import com.decimal.springsecurity.rest.model.entity.Address;
import com.decimal.springsecurity.rest.model.entity.Customer;
import com.decimal.springsecurity.rest.model.mapper.AddressMapper;
import com.decimal.springsecurity.rest.model.mapper.CustomerMapper;
import com.decimal.springsecurity.rest.model.request.AddCustomer;
import com.decimal.springsecurity.rest.model.response.AddressDto;
import com.decimal.springsecurity.rest.model.response.CustomerDto;
import com.decimal.springsecurity.rest.repository.AddressRepository;
import com.decimal.springsecurity.rest.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServicePgImpl implements CustomerService {
    private static final CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);
    private static final AddressMapper ADDRESS_MAPPER = Mappers.getMapper(AddressMapper.class);
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public CustomerDto addCustomer(AddCustomer addCustomer) {
        Customer customer = customerRepository.save(CUSTOMER_MAPPER.addRequestToEntity(addCustomer));
        CustomerDto customerDto = CUSTOMER_MAPPER.entityToDto(customer);
        Address address = ADDRESS_MAPPER.addRequestToEntity(addCustomer.getAddress());
        address.setCustomer(customer);
        AddressDto addressDto = ADDRESS_MAPPER.entityToDto(addressRepository.save(address));
        customerDto.setAddress(addressDto);
        return customerDto;
    }
}
