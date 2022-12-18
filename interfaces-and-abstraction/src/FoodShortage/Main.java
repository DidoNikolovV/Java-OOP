package FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        Set<Person> objects = new HashSet<>();

        for(int i = 0; i < numberOfPeople; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            if(tokens.length == 4) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                String birthdate = tokens[3];
                objects.add(new Citizen(name, age, id, birthdate));
            } else {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String group = tokens[2];
                objects.add(new Rebel(name, age, group));
            }

        }

        String line = scanner.nextLine();
        int totalBoughtFood = 0;

        while(!line.equals("End")) {
            String name = line;
            for (Person obj : objects) {
                if(obj.getName().equals(name)) {
                    obj.buyFood();
                }
            }

            line = scanner.nextLine();
        }

        for (Person obj : objects) {
            totalBoughtFood += obj.getFood();
        }


        System.out.println(totalBoughtFood);
    }
}
