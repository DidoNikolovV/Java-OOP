package Vehicles;

public abstract class Vehicle {
    double fuelQuantity;
    double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    abstract void drive(double distance);
    abstract void refuel(double fuel);

    boolean canDrive(double distance) {
        double fuelNeeded = this.fuelConsumption * distance;
        return this.fuelQuantity >= fuelNeeded;
    }



}
