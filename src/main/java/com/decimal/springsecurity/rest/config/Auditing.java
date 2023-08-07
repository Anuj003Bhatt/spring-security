package com.decimal.springsecurity.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.UUID;

@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@Configuration
public class Auditing {

    @Bean
    public AuditorAware<UUID> auditorProvider() {
        return new AuditorTranslator();
    }
}
