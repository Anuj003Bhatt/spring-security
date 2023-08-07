package com.decimal.springsecurity.rest.model.entity;

import com.decimal.springsecurity.rest.model.entity.base.BaseUuidEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@Table(name = "products")
public class Product extends BaseUuidEntity {

    @Column(name = "name", nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    private BigDecimal stock;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "products",fetch = FetchType.LAZY)
    private List<Order> orders;
}
