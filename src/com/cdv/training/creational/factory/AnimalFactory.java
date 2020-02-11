package com.cdv.training.creational.factory;

/**
 * Concrete creators override the factory method to change the resulting product's type.
 */
public class AnimalFactory extends AnimalCreator {

    @Override
    public Animal createAnimal(AnimalType animalType) {
        if (animalType == null) {
            return null;
        }
        if (animalType.equals(AnimalType.DOG)) {
            return new Dog();
        } else if (animalType.equals(AnimalType.CAT)) {
            return new Cat();
        }
        return null;
    }

}
