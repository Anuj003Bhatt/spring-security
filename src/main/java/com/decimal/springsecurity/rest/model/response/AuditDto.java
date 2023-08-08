package com.decimal.springsecurity.rest.model.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AuditDto {
    private LocalDateTime createdAt;
    private UUID createdBy;
    private LocalDateTime updatedAt;
    private UUID updatedBy;
}
