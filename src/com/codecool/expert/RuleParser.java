package com.codecool.expert;

import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepo;
    public static NodeList ruleList;
    
    public RuleRepository getRuleRepository() {
        return new RuleRepository();
    }

    public RuleParser() {
        this.ruleRepo = getRuleRepository();
        loadXmlDocument("src/com/codecool/expert/Rules.xml");
        this.ruleList = doc.getElementsByTagName("Question");
    }
}