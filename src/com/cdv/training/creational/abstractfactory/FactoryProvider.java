package com.cdv.training.creational.abstractfactory;

public class FactoryProvider {
    public static AbstractFactory getFactory(FactoryType factoryType) {
        if(factoryType.equals(FactoryType.CAR)) {
            return new CarFactory();
        } else if(factoryType.equals(FactoryType.MOTORCYCLE)) {
            return new MotorcycleFactory();
        }
        return null;
    }
}
