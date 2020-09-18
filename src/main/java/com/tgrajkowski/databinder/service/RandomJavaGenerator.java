package com.tgrajkowski.databinder.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomJavaGenerator {
    private final Random random;

    public RandomJavaGenerator() {
        this.random = new Random();
    }

    public List<Integer> gnerateRandomNumber(int countOfNumbers, int min, int max ) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < countOfNumbers; i++) {
            integerList.add(min+random.nextInt(max));
        }
        return integerList;
    }
}
