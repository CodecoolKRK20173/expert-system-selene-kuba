package com.codecool.expert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {
  private final List<Fact> facts;

  FactRepository() {
    this.facts = new ArrayList<>();
  }

  public void addFact(Fact fact) {
    this.facts.add(fact);
  }

  public Iterator<Fact> getIterator() {
    return new FactIterator(this.facts);
  }
}
