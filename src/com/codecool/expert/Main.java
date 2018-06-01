package com.codecool.expert;

import java.util.Iterator;

class Main {

  public static void main(String[] args) {
    RuleParser ruleParser = new RuleParser();
    FactParser factParser = new FactParser();
    
    ESProvider esProvider = new ESProvider(factParser, ruleParser);
  }
}