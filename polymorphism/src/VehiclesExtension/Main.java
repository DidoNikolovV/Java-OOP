package VehiclesExtension;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        String[] truckInfo = scanner.nextLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(carInfo[3]));
        String[] busInfo = scanner.nextLine().split(" ");
        Vehicle bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

        int nCommands = Integer.parseInt(scanner.nextLine());

        DecimalFormat format = new DecimalFormat("0.##");
        boolean hasIncreased = false;
        while(nCommands-- > 0) {
            String command = scanner.nextLine();
            String[] cmdParts = command.split(" ");
            String cmdType = cmdParts[0];
            if(isInvalid(cmdType)) {
                continue;
            }
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
                } else if(vehicleType.equals("Bus")) {
                    if(bus.canDrive(distance)) {
                        if(!hasIncreased) {
                            bus.fuelConsumption += 1.4;
                            hasIncreased = true;
                        }
                        bus.drive(distance);
                        System.out.println("Bus travelled " + format.format(distance) + " km" );
                    } else {
                        System.out.println("Bus needs refueling");
                    }
                }

            } else if(cmdType.equals("DriveEmpty")) {
                double distance = Double.parseDouble(cmdParts[2]);
                if(bus.canDrive(distance)) {
                    if(hasIncreased) {
                        bus.fuelConsumption -= 1.4;
                        hasIncreased = false;
                    }
                    bus.drive(distance);
                } else {
                    System.out.println("Bus needs refueling");
                }
            }else if(cmdType.equals("Refuel")) {
                double fuel = Double.parseDouble(cmdParts[2]);
                if(fuel <= 0) {
                    System.out.println("Fuel must be a positive number");
                } else {
                    if(vehicleType.equals("Car")) {
                        if(car.canRefuel(fuel)) {
                            car.refuel(fuel);
                        } else
                            {System.out.println("Cannot fit fuel in tank");
                        }
                    } else if(vehicleType.equals("Truck")) {
                        if(truck.canRefuel(fuel)) {
                            truck.refuel(fuel);
                        } else {
                            System.out.println("Cannot fit fuel in tank");

                        }
                    }  else if(vehicleType.equals("Bus")) {
                        if(bus.canRefuel(fuel)) {
                            bus.refuel(fuel);
                        } else {
                            System.out.println("Cannot fit fuel in tank");
                        }
                    }
                }

            }
        }

        System.out.printf("Car: %.2f%n", car.fuelQuantity);
        System.out.printf("Truck: %.2f%n", truck.fuelQuantity);
        System.out.printf("Bus: %.2f%n", bus.fuelQuantity);

    }

    public static boolean isInvalid(String cmd) {
        return !(cmd.equals("Drive") || cmd.equals("DriveEmpty") || cmd.equals("Refuel"));
    }
}
