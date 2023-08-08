package com.decimal.springsecurity.rest.model.mapper;

import com.decimal.springsecurity.rest.model.entity.Address;
import com.decimal.springsecurity.rest.model.request.AddAddress;
import com.decimal.springsecurity.rest.model.response.AddressDto;
import com.decimal.springsecurity.rest.util.DateUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {
        DateUtil.class
})
public interface AddressMapper {
    Address addRequestToEntity(AddAddress address);

    @Mapping(target = "createdAt", expression = "java(DateUtil.epochToLocalDateTime(address.getCreatedAt()))")
    @Mapping(target = "updatedAt", expression = "java(DateUtil.epochToLocalDateTime(address.getUpdatedAt()))")
    AddressDto entityToDto(Address address);
}
