package com.tgrajkowski.databinder.combiner;

import com.tgrajkowski.databinder.service.combiner.NumberProcessor;
import com.tgrajkowski.databinder.service.combiner.calculation.Calculation;
import com.tgrajkowski.databinder.service.combiner.impl.AddCalculation;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class NumberProcessorTest {

    @Test
    public void processNumbers() {
        NumberProcessor numberProcessor = new NumberProcessor();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(1);
        integerList.add(3);
        Calculation calculation = new AddCalculation();
        int result = numberProcessor.processNumbers(integerList, calculation);
        Assert.assertEquals(5, result);
    }

    @Test
    public void processNumbersNoData() {
        NumberProcessor numberProcessor = new NumberProcessor();
        List<Integer> integerList = new ArrayList<>();
        Calculation calculation = new AddCalculation();
        int result = numberProcessor.processNumbers(integerList, calculation);
        Assert.assertEquals(0, result);
    }

    @Test
    public void processNumbersOneElement() {
        NumberProcessor numberProcessor = new NumberProcessor();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        Calculation calculation = new AddCalculation();
        int result = numberProcessor.processNumbers(integerList, calculation);
        Assert.assertEquals(1, result);
    }
}
