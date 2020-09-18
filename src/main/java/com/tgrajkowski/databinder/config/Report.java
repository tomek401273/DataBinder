package com.tgrajkowski.databinder.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Report {
    private int id;
    private String reportName;
    private String content;
    private List<Integer> integerList =new ArrayList<>();

}
