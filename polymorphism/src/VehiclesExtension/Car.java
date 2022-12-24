package VehiclesExtension;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.fuelConsumption += 0.9;
    }

    @Override
    void drive(double distance) {
        double fuelNeeded = fuelConsumption * distance;
        this.fuelQuantity -= fuelNeeded;

    }

    @Override
    void refuel(double fuel) {
        this.fuelQuantity += fuel;
    }
}
