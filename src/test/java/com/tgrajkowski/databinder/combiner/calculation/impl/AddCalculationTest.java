package com.tgrajkowski.databinder.combiner.calculation.impl;

import org.junit.Assert;
import org.junit.Test;

public class AddCalculationTest {
    @Test
    public void addTest(){
        AddCalculation addCalculation= new AddCalculation();
        int result = addCalculation.calc(1, 2);
        Assert.assertEquals(3, result);
    }

}
