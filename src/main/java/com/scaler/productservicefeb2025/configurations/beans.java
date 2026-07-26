package com.scaler.productservicefeb2025.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class beans {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
