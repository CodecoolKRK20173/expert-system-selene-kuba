package com.codecool.expert;

import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepo;
    public NodeList ruleList;
    
    public RuleRepository getRuleRepository() {
        return this.ruleRepo;
    }

    public RuleParser() {
        loadXmlDocument("src/com/codecool/expert/Rules.xml");
        this.ruleList = doc.getElementsByTagName("Rule");
        this.ruleRepo = new RuleRepository(ruleList);
    }
}