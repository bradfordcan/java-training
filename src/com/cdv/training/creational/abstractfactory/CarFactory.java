package com.cdv.training.creational.abstractfactory;

import static com.cdv.training.creational.abstractfactory.VehicleType.SEDAN;

/**
* Concrete factories produce a family of products that belong to a single variant.
*/
public class CarFactory implements AbstractFactory {
    @Override
    public Vehicle createVehicle(VehicleType vehicleType) {
        if(vehicleType.equals(SEDAN)) {
            return new Sedan();
        }
        return null;
    }
}
