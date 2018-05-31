package com.codecool.expert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.w3c.dom.NodeList;

public class RuleRepository {

  public Map<String, Question> questionsMap = new HashMap<String, Question>();

  public void addQuestion(Question question) {
    questionsMap.put(question.getId(), question);
  }

  public Iterator<Question> getIterator() {
    List<Question> questions =  new ArrayList<>(questionsMap.values());
    return new QuestionIterator(questions);
  }
}


