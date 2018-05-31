package com.codecool.expert;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    private List<Value> values = new ArrayList<Value>();

    public boolean evaluateAnswerByInput(String input) {
        for (Value value : values) {
            if (value.getInputPattern().contains(input)) return true;
        } return false;
    }

    public void addValue(Value value) {
        this.values.add(value);
    }
}