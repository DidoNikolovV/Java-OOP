package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personInput = scanner.nextLine().split(";");
        List<Person> people = new ArrayList<>();
        for(String el: personInput) {
            String[] elParts = el.split("=");
            String name = elParts[0];
            Double money = Double.parseDouble(elParts[1]);
            Person person = new Person(name, money);
            people.add(person);
        }
    }
}
