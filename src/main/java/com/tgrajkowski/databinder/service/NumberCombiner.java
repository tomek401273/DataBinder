package com.tgrajkowski.databinder.service;

import com.tgrajkowski.databinder.combiner.NumberProcessor;
import com.tgrajkowski.databinder.combiner.calculation.impl.AddCalculation;
import com.tgrajkowski.databinder.model.NumberCombination;
import org.springframework.stereotype.Service;

import java.net.URI;
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

    public NumberCombination combineNumbers(){
        List<Integer> integerList= new ArrayList<>();;
        URI uri =randomApiService.createURI(2, 0, 10);
        integerList.addAll(randomApiService.getRandomNumberData(uri).getIntegerList());
        integerList.addAll(randomJavaGenerator.gnerateRandomNumber(2, 0 ,10));
        int result = numberProcessor.processNumbers(integerList, new AddCalculation());
        return new NumberCombination(integerList, result);
    }
}
