package com.tgrajkowski.databinder.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomJavaGenerator {
    private final Random random;

    public RandomJavaGenerator() {
        this.random = new Random();
    }

    public Integer gnerateRandomNumber(){
        return random.nextInt();
    }
}
