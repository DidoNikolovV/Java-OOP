package Vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        String[] truckInfo = scanner.nextLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int nCommands = Integer.parseInt(scanner.nextLine());

        DecimalFormat format = new DecimalFormat("0.##");

        while(nCommands-- > 0) {
            String command = scanner.nextLine();
            String[] cmdParts = command.split(" ");
            String cmdType = cmdParts[0];
            String vehicleType = cmdParts[1];
            if(cmdType.equals("Drive")) {
                double distance = Double.parseDouble(cmdParts[2]);
                if(vehicleType.equals("Car")) {
                    if(car.canDrive(distance)) {
                        car.drive(distance);
                        System.out.println("Car travelled " + format.format(distance) + " km");
                    } else {
                        System.out.println("Car needs refueling");
                    }
                } else if(vehicleType.equals("Truck")) {
                    if(truck.canDrive(distance)) {
                        truck.drive(distance);
                        System.out.println("Truck travelled " + format.format(distance) + " km");
                    } else {
                        System.out.println("Truck needs refueling");
                    }
                }

            } else if(cmdType.equals("Refuel")) {
                double fuel = Double.parseDouble(cmdParts[2]);
                if(vehicleType.equals("Car")) {
                    car.refuel(fuel);
                } else if(vehicleType.equals("Truck")) {
                    truck.refuel(fuel);
                }
            }
        }

        System.out.printf("Car: %.2f%n", car.fuelQuantity);
        System.out.printf("Truck: %.2f%n", truck.fuelQuantity);
    }
}
