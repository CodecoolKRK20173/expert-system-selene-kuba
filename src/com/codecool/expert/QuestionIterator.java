package com.codecool.expert;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class QuestionIterator implements Iterator {
    private List<Question> questions = new ArrayList<>();
    private int index;

    public QuestionIterator(List<Question> questions) {
        this.index = 0;
        this.questions = questions;
    }

    @Override
    public boolean hasNext() {
        return questions.size() > index;
    }

    @Override
    public Question next() {
        return questions.get(index++);
    }
}