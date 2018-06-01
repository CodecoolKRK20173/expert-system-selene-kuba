package com.codecool.expert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleRepository {

  private final Map<String, Question> questionsMap = new HashMap<>();

  public void addQuestion(Question question) {
    questionsMap.put(question.getId(), question);
  }

  public QuestionIterator getIterator() {
    List<Question> questions =  new ArrayList<>(questionsMap.values());
    return new QuestionIterator(questions);
  }
}


