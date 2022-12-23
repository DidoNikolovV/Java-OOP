package Vehicles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInput = scanner.nextLine().split(" ");
        String[] truckInput = scanner.nextLine().split(" ");

        Vehicle car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]));

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);

        int nCommands = Integer.parseInt(scanner.nextLine());

        while(nCommands-- > 0) {
            String[] inputLine = scanner.nextLine().split(" ");
            String command = inputLine[0];
            Vehicle vehicle = inputLine[1].equals("Car") ? vehicles.get(0) : vehicles.get(1);
            if(command.equals("Drive")) {
                double distance = Double.parseDouble(inputLine[2]);
                if(vehicle.canBeDriven(distance)) {
                    vehicle.drive(distance);
                    System.out.printf("%s travelled %.2f km%n", inputLine[1], distance);
                } else {
                    System.out.printf("%s needs refueling%n", inputLine[1]);
                }
            } else if(command.equals("Refuel")) {
                double liters = Double.parseDouble(inputLine[2]);
                vehicle.refuel(liters);
            }
        }

        for (Vehicle vehicle : vehicles) {
            System.out.printf("%s: %.2f%n", vehicle.getName(), vehicle.getFuelQuantity());
        }
    }
}
