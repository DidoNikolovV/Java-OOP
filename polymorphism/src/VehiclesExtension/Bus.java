package VehiclesExtension;

public class Bus extends  Vehicle{



    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);

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
