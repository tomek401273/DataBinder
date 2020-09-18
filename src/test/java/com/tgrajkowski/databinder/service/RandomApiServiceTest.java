package com.tgrajkowski.databinder.service;

import com.tgrajkowski.databinder.config.ApplicationConfig;
import com.tgrajkowski.databinder.model.RandomNumer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RandomApiServiceTest {
    @InjectMocks
    private RandomApiService randomApiService;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ApplicationConfig applicationConfig;

    @Test
    public void getData() {
        // given
        URI uri = UriComponentsBuilder.fromHttpUrl("http://test.com").build().encode().toUri();
        RandomNumer randomNumer = new RandomNumer(List.of(1, 2, 4));
        Mockito.when(restTemplate.getForObject(uri, RandomNumer.class)).thenReturn(randomNumer);
        // when
        RandomNumer randomNumberData = randomApiService.getRandomNumberData(uri);
        // then
        Assert.assertEquals(3, randomNumberData.getIntegerList().size());
        Assert.assertEquals(Integer.valueOf(4), randomNumberData.getIntegerList().get(2));

    }

    @Test
    public void createURI() {
        //given
        Mockito.when(applicationConfig.getRandomApi()).thenReturn("http://test.com");
        // when
        URI result = randomApiService.createURI(0, 2, 10);
        // then
        Assert.assertEquals("http://test.com?num=0&min=2&max=10&col=1&base=10&format=plain&rnd=new", result.toString());
    }
}
