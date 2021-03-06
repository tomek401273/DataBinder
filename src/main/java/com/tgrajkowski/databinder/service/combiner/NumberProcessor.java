package com.tgrajkowski.databinder.service.combiner;

import com.tgrajkowski.databinder.service.combiner.calculation.Calculation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NumberProcessor {
    public int processNumbers(List<Integer> integerList, Calculation calculation) {
        int sum = 0;
        for (Integer ele : integerList) {
            sum = calculation.calc(sum, ele);
        }
        return sum;
    }
}
