package com.tgrajkowski.databinder.controller;

import com.tgrajkowski.databinder.model.NumberCombination;
import com.tgrajkowski.databinder.service.NumberCombiner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DataBinderController.class)
public class DataBinderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private NumberCombiner numberCombiner;

    @Test
    public void getNumberCombination1() throws Exception {
        NumberCombination numberCombination = new NumberCombination(List.of(1, 2), 3);
        Mockito.when(numberCombiner.combineNumbers()).thenReturn(numberCombination);

        mockMvc.perform(get("/number/combination")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sum", is(3)))
                .andExpect(jsonPath("numbers", is(List.of(1, 2))));
    }
}
