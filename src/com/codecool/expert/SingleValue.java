package com.codecool.expert;

class SingleValue extends Value {

    public SingleValue(String param, boolean selectionType) {
        this.selectionType = selectionType;
        inputPattern.add(param);
    }
}