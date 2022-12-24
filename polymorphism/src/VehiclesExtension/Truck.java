package VehiclesExtension;

public class Truck extends Vehicle {


    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.fuelConsumption += 1.6;
    }

    @Override
    void drive(double distance) {
        double fuelNeeded = fuelConsumption * distance;
        this.fuelQuantity -= fuelNeeded;

    }

    @Override
    void refuel(double fuel) {
        this.fuelQuantity += fuel * 0.95;
    }
}
