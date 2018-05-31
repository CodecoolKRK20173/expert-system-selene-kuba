package com.codecool.expert;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

abstract class XMLParser {
  Document doc;

  void loadXmlDocument(String xmlPath) {
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
