package com.codecool.expert;

import java.util.List;

class MultipleValue extends Value {

    public MultipleValue(List<String> params, boolean selectionType) {
        this.selectionType = selectionType;
        inputPattern.addAll(params);
    }
}