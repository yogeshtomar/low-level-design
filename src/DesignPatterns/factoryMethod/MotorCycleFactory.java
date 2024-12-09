package DesignPatterns.factoryMethod;

public class MotorCycleFactory implements VehicleFactory {
    int count = 0;
    @Override
    public Vehicle createVehicle() {
        System.out.println("created new Motorcycle : " + count);
        return new MotorCycle();
    }
    
}
 