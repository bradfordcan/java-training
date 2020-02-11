package com.cdv.training.creational.factory;

/**
 * Concrete products provide various implementations of the product interface
 */
public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow...");
    }
}
