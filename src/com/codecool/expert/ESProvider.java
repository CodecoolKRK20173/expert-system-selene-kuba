package com.codecool.expert;


public class ESProvider {
    private RuleRepository ruleRepo;
    private FactRepository factRepo;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.ruleRepo = ruleParser.getRuleRepository();
        this.factRepo = factParser.getFactRepository();
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