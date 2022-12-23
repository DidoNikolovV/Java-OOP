package Vehicles;

public abstract class Vehicle {
    private String name;
    private double fuelQuantity;
    private double fuelConsumption;

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public abstract void drive(double distance);
    public abstract void refuel(double fuel);
    public abstract boolean canBeDriven(double distance);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
