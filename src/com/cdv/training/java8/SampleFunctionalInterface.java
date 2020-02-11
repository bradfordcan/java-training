package com.cdv.training.java8;

@FunctionalInterface
public interface SampleFunctionalInterface {

    // default and static methods
    void method1(String str);
    default void logInterfaceWithMethod(String str) {
        System.out.println("logging:  " + str);
    }

    static void printInterfaceWithMethod(String str) {
        System.out.println("printing:  " + str);
    }

}
