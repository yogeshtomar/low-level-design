package DesignPatterns.factoryMethod;

public class FactoryMethod {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        VanFactory vanFactory = new VanFactory();
        TruckFactory truckFactory = new TruckFactory();
        MotorCycleFactory motorCycleFactory = new MotorCycleFactory();

        Clients carClients = new Clients(carFactory);
        Vehicle car = carClients.getVehicle();
        car.printVehicle();
    
        Clients truckClients = new Clients(truckFactory);
        Vehicle truck = truckClients.getVehicle();
        truck.printVehicle();
        
        Clients vanClients = new Clients(vanFactory);
        Vehicle van = vanClients.getVehicle();
        van.printVehicle();

        Clients motorClients = new Clients(motorCycleFactory);
        Vehicle motor = motorClients.getVehicle();
        motor.printVehicle();
    }

    
}

class Clients {
    private Vehicle protoVehicle;

    public Clients(VehicleFactory factory) {
        protoVehicle = factory.createVehicle();
    }

    public Vehicle getVehicle() {
        return protoVehicle;
    }
}
