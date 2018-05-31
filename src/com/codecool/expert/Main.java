package com.codecool.expert;

import java.util.Iterator;

class Main {

  public static void main(String[] args) {
    FactParser factP = new FactParser();
   FactRepository factR = factP.getFactRepository();
    Iterator<Fact> iterF = factR.getIterator();
    RuleParser ruleP = new RuleParser();
    RuleRepository ruleR = new RuleRepository();

    ESProvider esp = new ESProvider(factP, ruleP);
    esp.evaluate();
  }
}