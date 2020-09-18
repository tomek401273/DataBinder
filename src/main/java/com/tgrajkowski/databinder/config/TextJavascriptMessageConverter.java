package com.tgrajkowski.databinder.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


    @Component
    public class TextJavascriptMessageConverter extends AbstractJackson2HttpMessageConverter {

        public TextJavascriptMessageConverter(ObjectMapper objectMapper) {
            super(objectMapper);
            setTextJavascriptAsSupportedMediaType();
        }

        private void setTextJavascriptAsSupportedMediaType() {
            List<MediaType> supportedMediaTypes = new ArrayList<>();
            supportedMediaTypes.add(new MediaType("text", "plain"));
            setSupportedMediaTypes(supportedMediaTypes);
        }
    }
