package com.decimal.springsecurity.rest.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig extends BaseApiConfig {

    @Bean
    public UserApi userApi(
            @Value("${core.user.api}") String baseUrl,
            @Value("${core.user.api.timeout}") long timeout
    ) {
        return createApi(baseUrl, timeout, UserApi.class);
    }
}
