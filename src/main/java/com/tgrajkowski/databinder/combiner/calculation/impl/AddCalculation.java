package com.tgrajkowski.databinder.combiner.calculation.impl;

import com.tgrajkowski.databinder.combiner.calculation.Calculation;

public class AddCalculation implements Calculation {
    @Override
    public int calc(int a, int b) {
        return a+b;
    }
}
