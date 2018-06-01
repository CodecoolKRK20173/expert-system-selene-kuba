package com.codecool.expert;

import java.util.*;

class ESProvider {
    private final FactRepository factRepository;
    private final RuleRepository ruleRepository;
    private Map<String, Boolean> answers;

    public ESProvider(FactParser factParser, RuleParser ruleParser){
         this.factRepository = factParser.getFactRepository();
         this.ruleRepository = ruleParser.getRuleRepository();
         clearScreen();
         collectAnswers();
         evaluate();
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
            if(isInputProper(userInput, question)){
                isAnswerCorrect = true;
                this.answers.put(question.getId(), question.getEvaluatedAnswer(userInput));
            }
            }
        }
    }

    private boolean isInputProper(String userInput, Question question) {
        List<Value> values = question.getAnswer().getValues();
        for (Value value : values) {
            for (String pattern : value.getInputPattern()) {
            if (pattern.equals(userInput)) return true;
            }
        } return false;
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

                if(this.answers.get(id).equals(fact.getValueById(id))) matches++;
            }
            if(matches == factIdSet.size()){
                isMatch = true;
                System.out.println("Twój typ samobójcy:\n" + fact.getDescription());
            }
        }
        if(!isMatch) System.out.println("Nie jesteś samobójcą i nie zostaniesz nim :( nie stać Cię!");
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }      

}