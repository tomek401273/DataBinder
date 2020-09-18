package com.tgrajkowski.databinder.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RandomApiServiceTest {
    @Autowired
    private RandomApiService randomApiService;

    @Test
    void getData() {
        randomApiService.getData(randomApiService.createURI());
    }

    @Test
    void createURI() {
    }
}
