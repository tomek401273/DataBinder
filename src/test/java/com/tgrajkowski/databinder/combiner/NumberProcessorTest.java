package com.tgrajkowski.databinder.combiner;

import com.tgrajkowski.databinder.combiner.calculation.Calculation;
import com.tgrajkowski.databinder.combiner.calculation.impl.AddCalculation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberProcessorTest {

    @Test
    void processNumbers() {
        NumberProcessor numberProcessor= new NumberProcessor();
        List<Integer> integerList= new ArrayList<>();
        integerList.add(1);
        integerList.add(1);
        integerList.add(3);
        Calculation calculation= new AddCalculation();
        int result = numberProcessor.processNumbers(integerList, calculation);
        System.out.println(result);
    }
}
