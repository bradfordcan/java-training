package com.cdv.training.structural.adapter;

/**
*  Implements Dog class to let the Bird adapter object act as a dog.
*/
public class BirdAdapter implements Dog {

    // Need to implement the interface your client expects to use
    Bird bird;

    public BirdAdapter(Bird bird) {
        // Reference to the object we are adapting
        this.bird = bird;
    }

    @Override
    public void bark() {
        bird.makeSound();
        bird.fly();
    }

}
