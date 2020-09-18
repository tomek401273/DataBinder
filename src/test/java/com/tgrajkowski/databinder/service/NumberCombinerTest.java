package com.tgrajkowski.databinder.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class NumberCombinerTest {
    @Autowired
    NumberCombiner numberCombiner;
    @Test
    void combineNumbers() {
        numberCombiner.combineNumbers();
    }
}
