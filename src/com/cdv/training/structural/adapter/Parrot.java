package com.cdv.training.structural.adapter;

public class Parrot implements Bird {

    @Override
    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp Chirp");
    }

}
