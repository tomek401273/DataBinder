package com.tgrajkowski.databinder.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class RandomJavaGeneratorTest {
    @Autowired
    private RandomJavaGenerator randomJavaGenerator;

    @Test
    void gnerateRandomNumber() {
        System.out.println(randomJavaGenerator.gnerateRandomNumber(0, 2, 10));
    }
}
