package com.decimal.springsecurity.rest.model.mapper;

import com.decimal.springsecurity.rest.model.entity.Address;
import com.decimal.springsecurity.rest.model.entity.Customer;
import com.decimal.springsecurity.rest.model.request.AddAddress;
import com.decimal.springsecurity.rest.model.request.AddCustomer;
import com.decimal.springsecurity.rest.model.response.CustomerDto;
import com.decimal.springsecurity.rest.util.DateUtil;
import com.decimal.springsecurity.rest.util.EncryptionUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(imports = {
        DateUtil.class,
        EncryptionUtil.class,
        List.class
})
public interface CustomerMapper {
    AddressMapper ADDRESS_MAPPER = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "addresses", expression = "java(List.of(addRequestAddressToEntity(addCustomer.getAddress())))")
    Customer addRequestToEntity(AddCustomer addCustomer);

    @Mapping(target = "createdAt", expression = "java(DateUtil.epochToLocalDateTime(customer.getCreatedAt()))")
    @Mapping(target = "updatedAt", expression = "java(DateUtil.epochToLocalDateTime(customer.getUpdatedAt()))")
    CustomerDto entityToDto(Customer customer);

    default Address addRequestAddressToEntity(AddAddress address) {
        return ADDRESS_MAPPER.addRequestToEntity(address);
    }
}
