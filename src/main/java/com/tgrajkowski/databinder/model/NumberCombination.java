package com.tgrajkowski.databinder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class NumberCombination {
    private List<Integer> numbers;
    private Integer sum;
}
