package com.tgrajkowski.databinder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class RandomNumer {
    private List<Integer> integerList;
}
