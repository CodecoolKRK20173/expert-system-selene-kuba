package com.codecool.expert;


public class ESProvider {
    RuleRepository ruleRepo;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.ruleRepo = ruleParser.getRuleRepository();
    }

    public void collectAnswers(){

    }

    public boolean getAnswerByQuestion(String questionId) {
        return true;
    }

    public String evaluate() {
        return "sss";
    }
}