package com.decimal.springsecurity.rest.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.UUID;

public class AuditorTranslator implements AuditorAware<UUID> {
    @Override
    public Optional<UUID> getCurrentAuditor() {
        return Optional.of(UUID.randomUUID());
    }
}
