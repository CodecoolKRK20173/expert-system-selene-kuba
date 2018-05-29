package com.codecool.expert;

public class FactParser extends XMLParser {

  public FactRepository fRepository;

  public FactParser() {
    this.fRepository = new FactRepository();
  }

  public FactRepository getFactRepository() {

    FactRepository repository = new FactRepository();
    loadXmlDocument("Fact.xml");
    NodeList factList = doc.getElementByTagName("Fact");
  }
}
