package com.cdv.training.creational.abstractfactory;

/**
 * Concrete factories produce a family of products that belong to a single variant.
 */
public class MotorcycleFactory implements AbstractFactory {
    @Override
    public Vehicle createVehicle(VehicleType vehicleType) {
        if (vehicleType.equals(VehicleType.SCOOTER)) {
            return new Scooter();
        } else if (vehicleType.equals(VehicleType.DIRT_BIKE)) {
            return new DirtBike();
        }
        return null;
    }
}
