package com.decimal.springsecurity.rest.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto extends AuditDto{
    private UUID id;
    private String streetAddress;
    private String postalCode;
    private String country;
}
