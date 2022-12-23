package Vehicles;

public class Car extends Vehicle{

    public Car(Double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setName("Car");
    }

    @Override
    public void drive(double distance) {
        if(canBeDriven(distance)) {
            double fuelLeft = this.getFuelQuantity() - (getFuelConsumption() + getFuelConsumption() * 1.9) * distance;
            this.setFuelQuantity(fuelLeft);
        }
    }

    @Override
    public void refuel(double fuel) {
        this.setFuelQuantity(this.getFuelQuantity() + fuel);
    }

    @Override
    public boolean canBeDriven(double distance) {
        double fuelNeeded = (getFuelConsumption() + (getFuelConsumption() * 0.9)) * distance;
        return this.getFuelQuantity() >= fuelNeeded;
    }

}
