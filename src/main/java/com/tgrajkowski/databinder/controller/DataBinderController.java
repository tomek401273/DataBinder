package com.tgrajkowski.databinder.controller;

import com.tgrajkowski.databinder.model.NumberCombination;
import com.tgrajkowski.databinder.service.NumberCombiner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataBinderController {
    private final NumberCombiner numberCombiner;

    public DataBinderController(NumberCombiner numberCombiner) {
        this.numberCombiner = numberCombiner;
    }

    @GetMapping(value = "number/combination")
    public NumberCombination getNumberCombination() {
        return numberCombiner.combineNumbers();
    }

}
