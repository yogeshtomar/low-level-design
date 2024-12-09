package DesignPatterns.factoryMethod;

public class CarFactory implements VehicleFactory{
    int count = 0;

    @Override
    public Vehicle createVehicle() {
        System.out.println("new car created: " + count++);
        return new Car();
    }
    
}
