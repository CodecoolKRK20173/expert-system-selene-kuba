package com.codecool.expert;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public abstract class XMLParser {
  public Document doc;

  public void loadXmlDocument(String xmlPath) {
    try {
      File file = new File(xmlPath);
      DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
      doc = dBuilder.parse(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
