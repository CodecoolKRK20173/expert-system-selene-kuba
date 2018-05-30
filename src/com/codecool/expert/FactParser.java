package com.codecool.expert;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser {

  public FactRepository fRepository;

  public FactParser() {
    this.fRepository = new FactRepository();
  }

  public FactRepository getFactRepository() {

    FactRepository fRepository = new FactRepository();
    loadXmlDocument("src/com/codecool/expert/Facts.xml");
    NodeList factList = doc.getElementsByTagName("Fact");
    for (int i = 0; i < factList.getLength(); i++) {
      Node node = factList.item(i);
      Element factElement = (Element) node;
      NodeList descriptions = factElement.getElementsByTagName("Description");
      Node descriptionNode = descriptions.item(0);
      Element descriptionElement = (Element) descriptionNode;
      String factId = factElement.getAttribute("id");
      String descriptionValue = descriptionElement.getAttribute("value");
      NodeList evalList = factElement.getElementsByTagName("Eval");
      Fact fact = new Fact(factId, descriptionValue);

      for (int j = 0; j < evalList.getLength(); j++) {
        Node evalNode = evalList.item(j);
        Element evalElement = (Element) evalNode;
        String evalId = evalElement.getAttribute("id");
        String evalText = evalElement.getTextContent();

        Boolean evalValue = Boolean.valueOf(evalText);

        fact.setFactValueById(evalId, evalValue);
      }
      fRepository.addFact(fact);
    }
    return fRepository;
  }
}
