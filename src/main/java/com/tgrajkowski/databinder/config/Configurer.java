package com.tgrajkowski.databinder.config;

import ch.qos.logback.classic.pattern.MessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

public class Configurer implements WebMvcConfigurer {
    public void configureMessageConverter(List<HttpMessageConverter<?>> converters){
        Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder= new Jackson2ObjectMapperBuilder();
        jackson2ObjectMapperBuilder.indentOutput(true);

        converters.add(new MappingJackson2HttpMessageConverter(jackson2ObjectMapperBuilder.build()));
    }
}
