package com.tgrajkowski.databinder.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApplicationConfig {
    @Value("${random-api}")
    private String randomApi;
}
