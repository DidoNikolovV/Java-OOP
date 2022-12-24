package VehiclesExtension;

public abstract class Vehicle {
    double fuelQuantity;
    double fuelConsumption;
    double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    abstract void drive(double distance);
    abstract void refuel(double fuel);

    boolean canDrive(double distance) {
        double fuelNeeded = this.fuelConsumption * distance;
        return this.fuelQuantity - fuelNeeded >= 0;
    }

    boolean canRefuel(double fuel) {
        return this.fuelQuantity + fuel <= tankCapacity;
    }


}
