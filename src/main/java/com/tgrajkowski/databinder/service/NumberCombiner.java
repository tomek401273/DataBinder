package com.tgrajkowski.databinder.service;

import com.tgrajkowski.databinder.combiner.NumberProcessor;
import com.tgrajkowski.databinder.combiner.calculation.impl.AddCalculation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberCombiner {
    private final RandomJavaGenerator randomJavaGenerator;
    private final RandomApiService randomApiService;
    private final NumberProcessor numberProcessor;

    public NumberCombiner(RandomJavaGenerator randomJavaGenerator, RandomApiService randomApiService, NumberProcessor numberProcessor) {
        this.randomJavaGenerator = randomJavaGenerator;
        this.randomApiService = randomApiService;
        this.numberProcessor = numberProcessor;
    }

    public void combineNumbers(){
        List<Integer> integerList= new ArrayList<>();;
        integerList.addAll(randomApiService.getRandomNumberData(2, 0, 10).getIntegerList());
        integerList.addAll(randomJavaGenerator.gnerateRandomNumber(2, 0 ,10));

        System.out.println(integerList);
        int result = numberProcessor.processNumbers(integerList, new AddCalculation());
        System.out.println(result);
    }
}
