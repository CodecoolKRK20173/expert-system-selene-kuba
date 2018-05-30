package com.codecool.expert;

import java.util.Iterator;
import java.util.List;

public class FactIterator implements Iterator<Fact> {
  public List<Fact> facts;
  public int index;

  public FactIterator(List<Fact> facts) {
    this.facts = facts;
    this.index = 0;
  }

  @Override
  public boolean hasNext() {

    if (this.facts.size() > index) return true;
    return false;
  }

  @Override
  public Fact next() {
    return this.facts.get(index++);
  }
}
