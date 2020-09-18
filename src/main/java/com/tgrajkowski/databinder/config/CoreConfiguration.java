package com.tgrajkowski.databinder.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CoreConfiguration {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
        restTemplate.getMessageConverters().add(new RandomNumberConverter());
        return restTemplate;
    }
}
