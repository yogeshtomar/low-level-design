package DesignPatterns.factoryMethod;

public class TruckFactory implements VehicleFactory {
    int count = 0;
    @Override
    public Vehicle createVehicle() {
        System.out.println("new Truck created: " + count++);
        return new Truck();
    }
    
}
