package com.codecool.expert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.w3c.dom.NodeList;

public class RuleRepository {

  public Map<String, Question> questionsMap = new HashMap<String, Question>();

  public RuleRepository() {
    QuestionIterator questIterator = new QuestionIterator();
    while (questIterator.hasNext()) {
      addQuestion(questIterator.next());
    }
  }

  public void addQuestion(Question question) {
    questionsMap.put(question.getId(), question);
  }

    private class QuestionIterator implements Iterator {
        private List<Question> questions = new ArrayList<>(questionsMap.values());
        private int index;

        public QuestionIterator() {
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
  }

  // public Iterator<Question> getIterator() {

  // }


