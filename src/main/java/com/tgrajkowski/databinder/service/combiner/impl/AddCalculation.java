package com.tgrajkowski.databinder.service.combiner.impl;

import com.tgrajkowski.databinder.service.combiner.calculation.Calculation;

public class AddCalculation implements Calculation {
    @Override
    public int calc(int a, int b) {
        return a+b;
    }
}
