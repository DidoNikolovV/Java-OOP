package Vehicles;

public class Car extends Vehicle{
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.fuelConsumption += 0.9;
    }

    @Override
    void drive(double distance) {
        this.fuelQuantity -= fuelConsumption * distance;
    }

    @Override
    void refuel(double fuel) {
        this.fuelQuantity += fuel;

    }
}
