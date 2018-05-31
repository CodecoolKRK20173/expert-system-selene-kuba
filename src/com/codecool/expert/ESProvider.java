package com.codecool.expert;

import java.util.*;

public class ESProvider {
    private FactRepository factRepository;
    private RuleRepository ruleRepository;
    private Map<String, Boolean> answers;

    public ESProvider(FactParser factParser, RuleParser ruleParser){
         this.factRepository = factParser.getFactRepository();
         this.ruleRepository = ruleParser.getRuleRepository();
         collectAnswers();
    }
    public void collectAnswers(){
        Iterator<Question> questionIterator = ruleRepository.getIterator();
        Question question;
        this.answers = new HashMap<>();
        while( questionIterator.hasNext()){
            question = getQuestion(questionIterator);
            boolean isAnswerCorrect = false;

            while(!isAnswerCorrect){
                System.out.println(question.getQuestion());
                String userInput = getUserAnswer();
                Boolean evaluatedAnswer = question.getEvaluatedAnswer(userInput);
            if(evaluatedAnswer){
                isAnswerCorrect = true;
                this.answers.put(question.getId(), question.getEvaluatedAnswer(userInput));
            }
            }
        }
        System.out.println(answers);

    }
    private String getUserAnswer(){
        Scanner scn = new Scanner(System.in);
        return scn.nextLine();
    }

    private Question getQuestion(Iterator<Question> questionIterator){
        return questionIterator.next();
    }

    public void evaluate(){
        Iterator<Fact> factIterator = this.factRepository.getIterator();
        boolean isMatch = false;
        while (factIterator.hasNext()){
            Fact fact = factIterator.next();
            Set<String> factIdSet = fact.getIdSet();
            int matches = 0;
            for (String id : factIdSet){

                if(this.answers.get(id).equals(fact.getValueById(id)))
                        matches++;
                }
            if(matches == factIdSet.size()){
                isMatch = true;
                System.out.println(fact.getDescription());
            }
        }
        if(!isMatch) System.out.println("Nie jesteś samobójcą - nie stać Cię :)");
    }

}