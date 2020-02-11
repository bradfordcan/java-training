package com.cdv.training.java8;

import java.util.Objects;
import java.util.function.Consumer;

public interface Java8Features {

    // forEach
    void populateList();
    void traverseUsingIterator();
    void traverseUsingForEach();
    void traverseWithConsumerInterface();

    // functional interfaces and lambda expressions
    void doFunctionalInterfaceAndLambda();

    // extension methods
    void doExecuteExtensionMethod();

    // stream api for bulk data operations on collections
    void doSequentialStream();
    void doParallelStream();
    void doGetSum();

    // date and time
    void doGetDateToday();
    void doGetSpecificDate();

    // sort and comparator
    void sortStrings();

    // concurrency
    void doExecuteSampleCallable();
    void doExecuteScheduledExecutor();
    void doExecuteMultipleCallable();

    void doSampleRecursion(int num);
}
