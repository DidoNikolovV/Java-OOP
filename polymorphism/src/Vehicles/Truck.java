package Vehicles;

public class Truck extends Vehicle{


    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.fuelConsumption += 1.6;
    }

    @Override
    void drive(double distance) {
        this.fuelQuantity -= fuelConsumption * distance;
    }

    @Override
    void refuel(double fuel) {
        this.fuelQuantity += fuel * 0.95;
    }
}
