package com.codecool.expert;

import java.util.Arrays;
import java.util.List;

import org.w3c.dom.*;

class RuleParser extends XMLParser {

    private final RuleRepository ruleRepo;
    private final NodeList ruleList;

    
    public RuleRepository getRuleRepository() {
        return this.ruleRepo;
    }

    public RuleParser() {
        loadXmlDocument("src/com/codecool/expert/Rules.xml");
        this.ruleList = doc.getElementsByTagName("Rule");
        this.ruleRepo = new RuleRepository();
        createRuleRepository();
    }
    private void createRuleRepository() {
        for (int i = 0; i < ruleList.getLength(); i++) {
            Element rule = (Element) ruleList.item(i);
            Element elementQuest = (Element) rule.getElementsByTagName("Question").item(0);
            NodeList selectionList = rule.getElementsByTagName("Selection");
            
            String id = rule.getAttribute("id");            
            String quest = elementQuest.getTextContent();
            Answer answer = new Answer();
            addValuesTo(answer, selectionList);
            Question question = new Question(id, quest, answer);
            ruleRepo.addQuestion(question);
        }
    }

    private void addValuesTo(Answer answer, NodeList selectionList) {
        for (int j = 0; j < selectionList.getLength(); j++) {
            Value value;
            Element selection = (Element) selectionList.item(j);                 
            Boolean answerType = selection.getAttribute("value").equals("true"); 
            NodeList values = selection.getElementsByTagName("SingleValue");
            value = isEmpty(values) ? addMultiValue(answerType, selection) : addSingleValue(answerType, values);
            answer.addValue(value);
        }
    }

    private Value addSingleValue(Boolean answerType, NodeList values) {
        String param = values.item(0).getAttributes().item(0).getNodeValue();
        SingleValue singleValue = new SingleValue(param, answerType);
        return (Value) singleValue;
    }

    private Value addMultiValue(Boolean answerType, Element selection) {
        Node params = selection.getElementsByTagName("MultipleValue").item(0).getAttributes().item(0);
        List<String> paramsInList = Arrays.asList(params.getNodeValue().split(","));
        MultipleValue multiValue = new MultipleValue(paramsInList, answerType);
        return (Value) multiValue;
    }

    private Boolean isEmpty(NodeList values) {
        return values.getLength() <= 0;
    }
}