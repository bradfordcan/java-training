package com.cdv.training.creational.factory;

/**
 * Concrete products provide various implementations of the product interface
 */
public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}
