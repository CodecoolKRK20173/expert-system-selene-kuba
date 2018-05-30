package com.codecool.expert;

import org.w3c.dom.NodeList;
import org.w3c.dom.*;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepo;
    public NodeList ruleList;
    
    public RuleRepository getRuleRepository() {
        return this.ruleRepo;
    }

    public RuleParser() {
        loadXmlDocument("src/com/codecool/expert/Rules.xml");
        this.ruleList = doc.getElementsByTagName("Rule");
        for (int i = 0; i < ruleList.getLength(); i++) {
            Element rule = (Element) ruleList.item(i);
            String id = rule.getAttribute("id");            
            NodeList questions = rule.getChildNodes();
            for (int j = 0; j < questions.getLength(); j++) {
                Node quest = questions.item(j);
                if ( quest.getNodeName().equals("Question")) {
                    String question = quest.getTextContent();
                    System.out.println(question);
                }
                if (quest.getNodeName().equals("MultipleValue")) {
                    System.out.print("DDDD");
                }
                
            }
            // Element an = (Element) question.item(3).getChildNodes().item(3);
            // System.out.println(an.getAttribute("value"));
            //String question = rule.getTextContent();
            //String question = rule.getTextContent();
            //int answer = rule.getChildNodes().getLength();

            // System.out.print(rule+""+question);
            System.out.println("-------");
        }
        //this.ruleRepo = getRuleRepository();
    }
}