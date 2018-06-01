package com.codecool.expert;

import java.util.Iterator;
import java.util.List;

class FactIterator implements Iterator<Fact> {
  private final List<Fact> facts;
  private int index;

  public FactIterator(List<Fact> facts) {
    this.facts = facts;
    this.index = 0;
  }

  @Override
  public boolean hasNext() {

      return this.facts.size() > index;
  }

  @Override
  public Fact next() {
    return this.facts.get(index++);
  }
}
