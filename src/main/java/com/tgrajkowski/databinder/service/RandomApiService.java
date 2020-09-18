package com.tgrajkowski.databinder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgrajkowski.databinder.config.ApplicationConfig;
import com.tgrajkowski.databinder.config.Report;
import com.tgrajkowski.databinder.config.ReportConverter;
import com.tgrajkowski.databinder.config.TextJavascriptMessageConverter;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
//        ResponseEntity<String> responseEntity= restTemplate.exchange(uri, HttpMethod.GET,null, String.class);
//        return Integer.valueOf(Objects.requireNonNull(responseEntity.getBody().trim()));
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

// Note: here we are making this converter to process any kind of response,
// not only application/*json, which is the default behaviour
        HttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        converter.setSupportedMediaTypes(List.of(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
//        messageConverters.add(converter);
//        messageConverters.add(stringHttpMessageConverter);
//        messageConverters.add(new TextJavascriptMessageConverter(new ObjectMapper()));
        messageConverters.add(new ReportConverter());
        restTemplate.setMessageConverters(messageConverters);
       Report s= restTemplate.getForObject(uri, Report.class);
        System.out.println("ssss: "+s);
        return -1;
    }

    public URI createURI (){
        System.out.println("randomApi: "+applicationConfig.getRandomApi());
        return UriComponentsBuilder.fromHttpUrl("https://www.random.org/integers/?num=20&min=100&max=600&col=1&base=10&format=plain&rnd=new")
                .build().encode().toUri();
    }
}
