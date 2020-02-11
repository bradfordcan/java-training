package com.cdv.training;

import com.cdv.training.creational.abstractfactory.*;
import com.cdv.training.creational.builder.Student;
import com.cdv.training.creational.builder.StudentBuilder;
import com.cdv.training.creational.factory.Animal;
import com.cdv.training.creational.factory.AnimalFactory;
import com.cdv.training.creational.factory.AnimalType;
import com.cdv.training.creational.prototype.Employee;
import com.cdv.training.creational.singleton.SampleSingleton;
import com.cdv.training.java8.Java8Samples;
import com.cdv.training.java8.SampleFunctionalInterface;
import com.cdv.training.structural.adapter.BirdAdapter;
import com.cdv.training.structural.adapter.Dog;
import com.cdv.training.structural.adapter.Parrot;
import com.cdv.training.structural.bridge.QuestionManager;
import com.cdv.training.structural.bridge.SampleQuestions;
import com.cdv.training.structural.decorator.BasicComputer;
import com.cdv.training.structural.decorator.Computer;
import com.cdv.training.structural.decorator.GamingComputer;
import com.cdv.training.structural.facade.ShopKeeper;

public class Main {

    public static void main(String[] args) {
        for (String s: args) {
            System.out.println(s);
        }

        doExecuteCreationalDesignPatternSamples();
        doExecuteStructuralDesignPatternSamples();
    }

    /**
     * Samples for Creational Design Patterns
     */
    public static void doExecuteCreationalDesignPatternSamples() {
        // Singleton
        SampleSingleton sampleSingleton = SampleSingleton.getInstance();
        System.out.println(sampleSingleton.getGreetings());

        // Factory
        AnimalFactory animalFactory = new AnimalFactory();
        Animal dog = animalFactory.createAnimal(AnimalType.DOG);
        dog.makeSound();

        // Abstract Factory
        AbstractFactory factory = FactoryProvider.getFactory(FactoryType.CAR);
        if (factory == null) {
            System.out.println("Factory for given name doesn't exist.");
            System.exit(1);
        }
        Vehicle sedan = factory.createVehicle(VehicleType.SEDAN);
        sedan.makeSound();

        factory = FactoryProvider.getFactory(FactoryType.MOTORCYCLE);
        if (factory == null) {
            System.out.println("Factory for given name doesn't exist.");
            System.exit(1);
        }
        Vehicle dirtBike = factory.createVehicle(VehicleType.DIRT_BIKE);
        dirtBike.makeSound();

        // Prototype
        Employee nikki = new Employee(120042, "Nikki");
        nikki.showRecord();
        Employee cloneNikki = (Employee) nikki.clone();
        cloneNikki.showRecord();

        // Builder
        Student beb = new StudentBuilder().setId(177).setName("Beb").build();
        System.out.println(beb);
    }

    /**
     * Samples for Behavioral Design Patterns
     */
    public static void doExecuteStructuralDesignPatternSamples() {
        // Adapter
        Parrot parrot = new Parrot();
        // Wrap a bird in a birdAdapter so that it  behaves like a dog
        Dog birdAdapter = new BirdAdapter(parrot);
        birdAdapter.bark();

        System.out.println("BirdAdapter...");
        birdAdapter.bark();

        // Bridge
        QuestionManager questions = new QuestionManager("Catalog Name");
        questions.q = new SampleQuestions();
        questions.deleteQuestion("How old are you?");
        questions.displayAllQuestions();
        questions.addQuestion("How are you?");
        questions.displayAllQuestions();

        // Decorator
        Computer gamingComputer = new GamingComputer(new BasicComputer());
        gamingComputer.assemble();

        // Facade
        ShopKeeper sk = new ShopKeeper();
        sk.iPhoneSale();

        Java8Samples java8Samples = new Java8Samples();
        // forEach
        java8Samples.traverseUsingIterator();
        java8Samples.traverseUsingForEach();
        java8Samples.traverseWithConsumerInterface();

        // Functional Interface
        java8Samples.logInterfaceWithMethod("hello");
        java8Samples.method1("yo");
        java8Samples.doFunctionalInterfaceAndLambda();

        // Stream API
        java8Samples.doSequentialStream();
        java8Samples.doParallelStream();
        java8Samples.doGetSum();

        // Date and Time
        java8Samples.doGetDateToday();
        java8Samples.doGetSpecificDate();

        // Concurrency
        java8Samples.doExecuteSampleCallable();
        // java8Samples.doExecuteScheduledExecutor();
        java8Samples.doExecuteMultipleCallable();

        java8Samples.doSampleRecursion(4);

    }

}
