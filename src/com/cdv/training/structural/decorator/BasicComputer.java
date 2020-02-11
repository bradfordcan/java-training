package com.cdv.training.structural.decorator;

public class BasicComputer implements Computer {

    @Override
    public void assemble() {
        System.out.println("Assembling a basic computer.");
    }

}
