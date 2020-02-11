package com.cdv.training.java8;

public interface ExtensionMethodInterface {
    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
