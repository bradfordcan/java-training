package com.cdv.training.creational.abstractfactory;

/**
 * Concrete products are created by corresponding concrete factories.
 */
public class Scooter implements Vehicle {
    @Override
    public void makeSound() {
        System.out.println("Scooter:  ...");
    }
}
