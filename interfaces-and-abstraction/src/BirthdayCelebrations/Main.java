package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Birthable> birthables = new ArrayList<>();

        while(!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            if(tokens[0].equals("Citizen")) {
                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthDate = tokens[4];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                birthables.add(citizen);
            } else if(tokens[0].equals("Robot")) {
                String model = tokens[1];
                String id = tokens[2];
                Robot robot = new Robot(model, id);
            } else if(tokens[0].equals("Pet")) {
                String name = tokens[1];
                String birthdate = tokens[2];
                Pet pet = new Pet(name, birthdate);
                birthables.add(pet);
            }

            input = scanner.nextLine();
        }

        String specificYear = scanner.nextLine();

        for (Birthable birthable : birthables) {
            String currentYear = birthable.getBirthDate().split("/")[2];
            if(currentYear.equals(specificYear)) {
                System.out.println(birthable.getBirthDate());
            }
        }


    }
}
