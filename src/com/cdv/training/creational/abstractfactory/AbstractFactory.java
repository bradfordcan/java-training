package com.cdv.training.creational.abstractfactory;

/**
 * The abstract factory interface declares a set of methods that return different abstract products.
 */
public interface AbstractFactory {

    public Vehicle createVehicle(VehicleType vehicleType);

}
