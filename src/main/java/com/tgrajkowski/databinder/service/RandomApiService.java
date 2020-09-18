package com.tgrajkowski.databinder.service;

import com.tgrajkowski.databinder.config.ApplicationConfig;
import com.tgrajkowski.databinder.config.RandomNumer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RandomApiService {
    private final RestTemplate restTemplate;
    private final ApplicationConfig applicationConfig;

    public RandomApiService(RestTemplate restTemplate, ApplicationConfig applicationConfig) {
        this.restTemplate = restTemplate;
        this.applicationConfig = applicationConfig;
    }

    public RandomNumer getRandomNumberData(URI uri ) {
        return restTemplate.getForObject(uri, RandomNumer.class);
    }

    public URI createURI(int countOfNumbers, int min, int max ) {
        return UriComponentsBuilder.fromHttpUrl(applicationConfig.getRandomApi())
                .queryParam("num", countOfNumbers)
                .queryParam("min", min)
                .queryParam("max", max)
                .queryParam("col", 1)
                .queryParam("base", 10)
                .queryParam("format", "plain")
                .queryParam("rnd", "new")
                .build().encode().toUri();
    }
}
