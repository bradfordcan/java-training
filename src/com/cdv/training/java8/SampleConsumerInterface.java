package com.cdv.training.java8;

import java.util.function.Consumer;

/**
* Consumer implementation that can be reused
*/
public class SampleConsumerInterface implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        System.out.println("Consumer impl Value:  " + integer);
    }

}
