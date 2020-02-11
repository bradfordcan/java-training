package com.cdv.training.creational.abstractfactory;

/**
 * Concrete products are created by corresponding concrete factories.
 */
public class DirtBike implements Vehicle {
    @Override
    public void makeSound() {
        System.out.println("DirtBike:  Purru purru purru...");
    }
}
