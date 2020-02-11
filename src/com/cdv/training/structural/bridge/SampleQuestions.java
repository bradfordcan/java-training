package com.cdv.training.structural.bridge;

import java.util.ArrayList;
import java.util.List;

/**
* Delegates all of the real work to this object.
*/
public class SampleQuestions implements Question {

    private List<String> questions = new ArrayList<>();

    private int current = 0;

    public SampleQuestions() {
        questions.add("Do you like beplop?");
        questions.add("How old are you?");
    }

    @Override
    public void nextQuestion() {
        if (current <= questions.size() - 1) {
            current++;
        }
    }

    @Override
    public void previousQuestion() {
        if (current > 0) {
            current--;
        }
    }

    @Override
    public void addQuestion(String q) {
        questions.add(q);
    }

    @Override
    public void deleteQuestion(String q) {
        questions.remove(q);
    }

    @Override
    public void displayQuestion() {
        System.out.println(questions.get(current));
    }

    @Override
    public void displayAllQuestions() {
        for (String question : questions) {
            System.out.println(question);
        }
    }

}
