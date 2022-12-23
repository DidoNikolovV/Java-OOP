package Vehicles;

public class Truck extends Vehicle{
    public Truck(Double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setName("Truck");
    }
    @Override
    public void drive(double distance) {
        if(canBeDriven(distance)) {
            double fuelLeft = this.getFuelQuantity() - (getFuelConsumption() + getFuelConsumption() * 1.6) * distance;
            this.setFuelQuantity(fuelLeft);
        }
    }

    @Override
    public void refuel(double fuel) {
        this.setFuelQuantity(this.getFuelQuantity() + (fuel * 0.95));

    }

    @Override
    public boolean canBeDriven(double distance) {
        double fuelNeeded = (getFuelConsumption() + (getFuelConsumption() * 1.6)) * distance;
        return this.getFuelQuantity() >= fuelNeeded;
    }

}
