package WildFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mammal mammal = null;
        Felime felime = null;
        Food food = null;
        String line = scanner.nextLine();
        while(!line.equals("End")) {
            String[] animalInfo = line.split(" ");
            String type = animalInfo[0];
            if(type.equals("Cat")) {
                String name = animalInfo[1];
                double weight = Double.parseDouble(animalInfo[2]);
                String livingRegion = animalInfo[3];
                String breed = animalInfo[4];
                felime = new Cat(type, name, weight, livingRegion, breed);
            } else {
                String name = animalInfo[1];
                double weight = Double.parseDouble(animalInfo[2]);
                String livingRegion = animalInfo[3];
                if(type.equals("Tiger")) {
                    felime = new Tiger(type, name, weight, livingRegion);
                } else if(type.equals("Mouse")) {
                    mammal = new Mouse(type, name, weight, livingRegion);
                } else if(type.equals("Zebra")) {
                    mammal = new Zebra(type, name, weight, livingRegion);
                }
            }

            String[] foodInfo = scanner.nextLine().split(" ");
            String foodType = foodInfo[0];
            Integer foodQuantity = Integer.parseInt(foodInfo[1]);
            if(foodType.equals("Vegetable")) {
                food = new Vegetable(foodQuantity);
            } else if(foodType.equals("Meat")) {
                food = new Meat(foodQuantity);
            }

            if(type.equals("Cat") || type.equals("Tiger")) {
                felime.makeSound();
            } else {
                mammal.makeSound();
            }

            if(mammal.getAnimalType().equals("Zebra") || mammal.getAnimalType().equals("Mouse")) {
                if(foodType.equals("Vegetable")) {
                    mammal.eat(food);
                } else {
                    System.out.printf("%ss are not eating that type of food!%n", mammal.getAnimalType());
                }
            }
            if(felime.getAnimalType().equals("Tiger")) {
                if(foodType.equals("Meat")) {
                    felime.eat(food);
                } else {
                    System.out.printf("%ss are not eating that type of food!%n", felime.getAnimalType());
                }
            } else {
                felime.eat(food);
            }
            line = scanner.nextLine();
        }

        if(mammal != null) {
            System.out.printf("%s[%s, %f, %s, %d]",
                    mammal.getAnimalType(),
                    mammal.getAnimalName(),
                    mammal.getAnimalWeight(),
                    mammal.getLivingRegion(),
                    mammal.getFoodEaten());
        }
    }
}
