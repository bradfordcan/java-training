package com.cdv.training.structural.bridge;

/**
* Act as a bridge
*/
public class QuestionManager {

    public SampleQuestions q;

    public String catalog;

    public QuestionManager(String catalog) {
        this.catalog = catalog;
    }

    public void next() {
        q.nextQuestion();
    }

    public void addQuestion(String newQuestion) {
        q.addQuestion(newQuestion);
    }

    public void deleteQuestion(String questionToDelete) {
        q.deleteQuestion(questionToDelete);
    }

    public void display() {
        q.displayQuestion();
    }

    public void displayAllQuestions() {
        System.out.println("Catalog:  " + catalog);
        q.displayAllQuestions();
    }

}
