package DesignPatterns.factoryMethod;

public class VanFactory implements VehicleFactory{
    int count = 0;
    @Override
    public Vehicle createVehicle() {
        System.out.println("created new van: " + count++);
        return new Van();
    }
}
