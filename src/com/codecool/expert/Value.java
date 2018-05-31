package com.codecool.expert;

import java.util.ArrayList;
import java.util.List;

abstract class Value {
    final List<String> inputPattern = new ArrayList<>();
    boolean selectionType;
    
    
    public List<String> getInputPattern() {
        return inputPattern;
    }

    public boolean getSelectionType() {
        return this.selectionType;
    }
    
}