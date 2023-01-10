package strategyPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person person = new Person("Pesho", "Ivanov");
        Person person2 = new Person("Ivan", "Petrov");
        Person person3 = new Person("Dimitar", "Asenov");

        people.add(person);
        people.add(person2);
        people.add(person3);

        Collections.sort(people, new FirstNameSorter());
        Collections.sort(people, new LastNameSorter().reversed());


    }
}
