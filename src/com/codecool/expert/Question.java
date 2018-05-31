package com.codecool.expert;

public class Question {
    private String id;
    private String question;
    private Answer answer;

    public Question(String id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getId() {
        return this.id;
    }

    public Answer getAnswer(){
        return this.answer;
    }

    public boolean getEvaluatedAnswer(String input) {
        try{
            return answer.evaluateAnswerByInput(input);
        }catch(IllegalArgumentException e){
            System.out.println("NO OPTION!");
        }
        return false;
    }
    public String getQuestion(){
        return this.question;
    }
}