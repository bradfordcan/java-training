package com.cdv.training.creational.factory;

/**
 * Declares the factory method that must return an object of a product class.
 */
public abstract class AnimalCreator {

    /**
     * The creator's primary responsibility isn't creating products.
     * It usually contains some core business logic that relies on product objects returned by the factory method.
     */
    abstract Animal createAnimal(AnimalType animalType);

}
