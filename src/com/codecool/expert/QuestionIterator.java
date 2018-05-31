package com.codecool.expert;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class QuestionIterator implements Iterator {
    private List<Question> questions = new ArrayList<>();
    private int index;

    public QuestionIterator(List<Question> questions) {
        this.index = 0;
        this.questions = questions;
    }

    @Override
    public boolean hasNext() {
        if (questions.size() > index) return true;
        return false;
    }

    @Override
    public Question next() {
        Question question = questions.get(index++);
        //this.index = index++;
        System.out.print(question);
        return question;
    }
}