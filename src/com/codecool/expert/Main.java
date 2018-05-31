package com.codecool.expert;

import java.util.Iterator;
import java.util.Map.*;

public class Main {

  public static void main(String[] args) {
    FactRepository factR = new FactRepository();
    FactParser factP = new FactParser();
    factR = factP.getFactRepository();
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
