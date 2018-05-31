package com.codecool.expert;

import java.util.ArrayList;
import java.util.List;

public abstract class Value {
    public List<String> inputPattern = new ArrayList<String>();
    public boolean selectionType;
    
    
    public List<String> getInputPattern() {
        return inputPattern;
    }

    public boolean getSelectionType() {
        return this.selectionType;
    }
    
}