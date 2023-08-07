package com.decimal.springsecurity.rest.model.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Long createdAt;

    @Column(name = "created_by", nullable = false)
    @CreatedBy
    private UUID createdBy;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Long updatedAt;

    @Column(name = "updated_by")
    @LastModifiedBy
    private UUID updatedBy;
}
