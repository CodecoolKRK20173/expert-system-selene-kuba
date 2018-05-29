package com.codecool.expert;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RuleRepository {

    private final Map<String, Question> questions = new HashMap<String, Question>();

    public RuleRepository() {
        QuestionIterator questIterator = new QuestionIterator();
    }

    public void addQuestion(Question question) {
        questions.put(question.getId(), question);
    }

    private class QuestionIterator implements Iterator {
        @Override
        public boolean hasNext() {
            if (questions.size() < RuleParser.ruleList.getLength()) return true;
            return false;
        }

        @Override
        public Object next() {
            return new Object();
        }
    }

    // public Iterator<Question> getIterator() {

    // }

}