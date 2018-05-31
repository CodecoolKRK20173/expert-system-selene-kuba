package com.codecool.expert;

import java.util.Iterator;

public class Main {

  public static void main(String[] args) {
    FactParser factP = new FactParser();
   FactRepository factR = factP.getFactRepository();
    Iterator<Fact> iterF = factR.getIterator();
    while (iterF.hasNext()) {
      Fact fact = iterF.next();
      System.out.println(fact.id);
      System.out.println(fact.getDescription());
      System.out.println(fact.getIdSet());
      System.out.println(fact.getValueSet());
    }
  }
}
