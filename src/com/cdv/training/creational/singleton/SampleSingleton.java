package com.cdv.training.creational.singleton;

public class SampleSingleton {

    // private static SampleSingleton instance = new SampleSingleton();  // instance will be created at load time
    // The field for storing the singleton
    private static SampleSingleton instance = null;

    // The singleton's constructor should always be private to prevent direct construction calls with the new operator
    private SampleSingleton() {

    }

    // global point of access
    // if you're creating an app with multi threading support, you should place a thread lock here
    public static SampleSingleton getInstance() {
        if(instance == null) {
            synchronized (SampleSingleton.class) {
                if(instance == null) {
                    return new SampleSingleton(); // instance will be created at request time
                }
            }
        }
        return instance;
    }

    // some business logic method which can be executed on its instance
    public String getGreetings() {
        return "Hello mga ka beplop!";
    }

} // End of SampleSingleton class
