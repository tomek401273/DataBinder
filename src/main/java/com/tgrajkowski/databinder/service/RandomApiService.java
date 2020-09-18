package com.tgrajkowski.databinder.service;

import com.tgrajkowski.databinder.config.ApplicationConfig;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@Service
public class RandomApiService {
    private final RestTemplate restTemplate;
    private final ApplicationConfig applicationConfig;

    public RandomApiService(RestTemplate restTemplate, ApplicationConfig applicationConfig) {
        this.restTemplate = restTemplate;
        this.applicationConfig = applicationConfig;
    }

    public Integer getData(URI uri){
        ResponseEntity<String> responseEntity= restTemplate.exchange(uri, HttpMethod.GET,null, String.class);
        return Integer.valueOf(Objects.requireNonNull(responseEntity.getBody().trim()));
    }

    public URI createURI (){
        System.out.println("randomApi: "+applicationConfig.getRandomApi());
        return UriComponentsBuilder.fromHttpUrl("https://www.random.org/integers/?num=1&min=1&max=6&col=1&base=10&format=plain&rnd=new")
                .build().encode().toUri();
    }
}
