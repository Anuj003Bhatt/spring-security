package com.decimal.springsecurity.rest.model.entity;

import com.decimal.springsecurity.rest.model.entity.base.BaseUuidEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "customers")
public class Customer extends BaseUuidEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;
}
