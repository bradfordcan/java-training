package com.cdv.training.java8;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Java8Samples implements Java8Features, SampleFunctionalInterface {

    private List<Integer> list = new ArrayList<>();

    public Java8Samples() {
    }

    @Override
    public void populateList() {
        list.clear();
        for(int i = 0; i < 5; i++) {
            list.add(i);
        }
    }

    @Override
    public void traverseUsingIterator() {
        populateList();
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {
            Integer i = it.next();
            System.out.println("Iterator value:  " + i);
        }
    }

    @Override
    public void traverseUsingForEach() {
        populateList();
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("forEach anonymous class Value:  " + integer);
            }
        });
    }

    @Override
    public void traverseWithConsumerInterface() {
        populateList();
        SampleConsumerInterface consumer = new SampleConsumerInterface();
        list.forEach(consumer);
    }

    @Override
    public void doFunctionalInterfaceAndLambda() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable sample");
            }
        };

        // Using lambda expression
        Runnable r1 = () -> {
            System.out.println("Lambda Runnable");
        };

        // Lambda expression and functional interface
        SampleFunctionalInterface sampleFunctionalInterface = (s) -> System.out.println(s);
        sampleFunctionalInterface.method1("hello world");
    }

    @Override
    public void method1(String str) {
        System.out.println("Java8Samples logging:  " + str);
        SampleFunctionalInterface.printInterfaceWithMethod(str);
    }

    @Override
    public void doExecuteExtensionMethod() {
        ExtensionMethodInterface extensionMethodInterface = new ExtensionMethodInterface() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        extensionMethodInterface.calculate(100);
        extensionMethodInterface.sqrt(16);
    }

    @Override
    public void doSequentialStream() {
        populateList();
        Stream<Integer> sequentialStream = list.stream();
        Stream<Integer> highNumSeq = sequentialStream.filter(p -> p > 2);
        highNumSeq.forEach(p -> System.out.println("High num sequential = " + p));
    }

    @Override
    public void doParallelStream() {
        populateList();
        Stream<Integer> parallelStream = list.parallelStream();
        Stream<Integer> highNumSeq = parallelStream.filter(p -> p < 2);
        highNumSeq.forEach(p -> System.out.println("High num parallel = " + p));
    }

    @Override
    public void doGetSum() {
        populateList();
        System.out.println("Sum is: " + list.stream().mapToInt(i -> i).sum());
    }

    @Override
    public void doGetDateToday() {
        LocalDate today = LocalDate.now();
        System.out.println("Current date:  " + today);
    }

    @Override
    public void doGetSpecificDate() {
        LocalDate date = LocalDate.of(1997, Month.DECEMBER, 27);
        System.out.println("Date of birth (plus 15 days):  "+ date.plusDays(15));
    }

    @Override
    public void sortStrings() {
        List<String> names = Arrays.asList("beb", "leonille", "khrestee", "beboy");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        // Using Lambda
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        Collections.sort(names, (a, b) -> b.compareTo(a));
    }

    @Override
    public void doExecuteSampleCallable() {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                return 123;
            } catch(InterruptedException e) {
                throw new IllegalStateException("Task interrupted", e);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // submit() doesn't wait until the task completes,
        // the executor service cannot return the result of the callable directly.
        // Instead the executor returns a special result of type Future
        // which can be used to retrieve the actual result at a later point in time
        Future<Integer> future = executorService.submit(task);

        try {
            // Calling the method get() blocks the current thread
            // and waits until the callable completes before return the actual result
            Integer result = future.get();
            System.out.println("Future done? " + future.isDone());
            System.out.print("Result: " + result);
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            System.err.println("tasks interrupted");
        } finally {
            if(!executorService.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("shutdown finished");
        }

        // Futures are tightly coupled to the underlying executor service.
        // Keep in mind that every non-terminated future will throw exceptions if you shutdown the executor
    }

    @Override
    public void doExecuteScheduledExecutor() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable newTask = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        scheduledExecutorService.scheduleWithFixedDelay(newTask, 0, 2, TimeUnit.SECONDS);
    }

    @Override
    public void doExecuteMultipleCallable() {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> calls = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        try {
            executor.invokeAll(calls)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch(Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doSampleRecursion(int num) {
        if(num < 1) {
        } else {
            System.out.print(num);
            doSampleRecursion(num - 1);
            System.out.print(num);
        }
    }

}
