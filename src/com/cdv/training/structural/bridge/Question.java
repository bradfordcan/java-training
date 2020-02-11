package com.cdv.training.structural.bridge;

/**
* The implementation interface declares methods common to all concrete implementation classes.
*/
public interface Question {

    public void nextQuestion();
    public void previousQuestion();
    public void addQuestion(String q);
    public void deleteQuestion(String q);
    public void displayQuestion();
    public void displayAllQuestions();

}
