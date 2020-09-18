package com.tgrajkowski.databinder.service;

import com.tgrajkowski.databinder.combiner.NumberProcessor;
import com.tgrajkowski.databinder.combiner.calculation.impl.AddCalculation;
import com.tgrajkowski.databinder.config.RandomNumer;
import com.tgrajkowski.databinder.model.NumberCombination;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class NumberCombinerTest {
    @InjectMocks
    NumberCombiner numberCombiner;
    @Mock
    private RandomJavaGenerator randomJavaGenerator;
    @Mock
    private RandomApiService randomApiService;
    @Mock
    private NumberProcessor numberProcessor;

    @Test
    public void combineNumbers() {
        // given
        URI uri = UriComponentsBuilder.fromHttpUrl("http://test.com").build().encode().toUri();
        RandomNumer randomNumerApi = new RandomNumer(List.of(1));
        Mockito.when(randomApiService.createURI(2, 0, 10)).thenReturn(uri);
        Mockito.when(randomApiService.getRandomNumberData(uri)).thenReturn(randomNumerApi);
        Mockito.when(randomJavaGenerator.gnerateRandomNumber(2, 0, 10)).thenReturn(List.of(2));
        Mockito.when(numberProcessor.processNumbers(Mockito.any(), Mockito.any())).thenReturn(3);
        // when
        NumberCombination numberCombination = numberCombiner.combineNumbers();
        // then
        Assert.assertEquals(List.of(1, 2), numberCombination.getNumbers());
        Assert.assertEquals(Integer.valueOf(3), numberCombination.getSum());
    }

    @Test
    public void combineNumbersNoDataFormApi() {
        // given
        URI uri = UriComponentsBuilder.fromHttpUrl("http://test.com").build().encode().toUri();
        RandomNumer randomNumerApi = new RandomNumer(List.of());
        Mockito.when(randomApiService.createURI(2, 0, 10)).thenReturn(uri);
        Mockito.when(randomApiService.getRandomNumberData(uri)).thenReturn(randomNumerApi);
        Mockito.when(randomJavaGenerator.gnerateRandomNumber(2, 0, 10)).thenReturn(List.of(2));
        Mockito.when(numberProcessor.processNumbers(Mockito.any(), Mockito.any())).thenReturn(2);
        // when
        NumberCombination numberCombination = numberCombiner.combineNumbers();
        // then
        Assert.assertEquals(List.of( 2), numberCombination.getNumbers());
        Assert.assertEquals(Integer.valueOf(2), numberCombination.getSum());
    }


    @Test
    public void combineNumbersNoDataFormJavaGenerator() {
        // given
        URI uri = UriComponentsBuilder.fromHttpUrl("http://test.com").build().encode().toUri();
        RandomNumer randomNumerApi = new RandomNumer(List.of(1));
        Mockito.when(randomApiService.createURI(2, 0, 10)).thenReturn(uri);
        Mockito.when(randomApiService.getRandomNumberData(uri)).thenReturn(randomNumerApi);
        Mockito.when(randomJavaGenerator.gnerateRandomNumber(2, 0, 10)).thenReturn(List.of());
        Mockito.when(numberProcessor.processNumbers(Mockito.any(), Mockito.any())).thenReturn(1);
        // when
        NumberCombination numberCombination = numberCombiner.combineNumbers();
        // then
        Assert.assertEquals(List.of(1), numberCombination.getNumbers());
        Assert.assertEquals(Integer.valueOf(1), numberCombination.getSum());
    }


}
