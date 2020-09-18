package com.tgrajkowski.databinder.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class RandomJavaGeneratorTest {
    @Autowired
    private RandomJavaGenerator randomJavaGenerator;

    @Test
    public void gnerateRandomNumber() {
        // given & when
        List<Integer> result = randomJavaGenerator.gnerateRandomNumber(2, 2, 10);
        // then
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(-20 < result.get(0));
        Assert.assertTrue(20 > result.get(0));
    }
}
