package com.cdv.training.structural.decorator;

public class GamingComputer extends ComputerDecorator {

    public GamingComputer(Computer computer) {
        super(computer);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding characteristics of a work computer!");
    }

}
