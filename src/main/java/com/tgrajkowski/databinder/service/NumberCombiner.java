package com.tgrajkowski.databinder.service;

import org.springframework.stereotype.Service;

@Service
public class NumberCombiner {
    private final RandomJavaGenerator randomJavaGenerator;
    private final RandomApiService randomApiService;

    public NumberCombiner(RandomJavaGenerator randomJavaGenerator, RandomApiService randomApiService) {
        this.randomJavaGenerator = randomJavaGenerator;
        this.randomApiService = randomApiService;
    }

    public void combineNumbers(){
        Integer firstNumber = randomApiService.getData(randomApiService.createURI());
        Integer secondNumber = randomJavaGenerator.gnerateRandomNumber();
        Integer result = firstNumber+secondNumber;
        System.out.println("firstNumber: "+firstNumber+" secondNumber: "+secondNumber);
        System.out.println(result);
    }
}
