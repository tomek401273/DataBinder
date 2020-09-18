package com.tgrajkowski.databinder.service;

import com.tgrajkowski.databinder.config.RandomNumer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RandomApiServiceTest {
    @Autowired
    private RandomApiService randomApiService;

    @Test
    void getData() {
        RandomNumer randomNumberData = randomApiService.getRandomNumberData(0, 2, 10);
        System.out.println(randomNumberData);

    }

    @Test
    void createURI() {
    }
}
