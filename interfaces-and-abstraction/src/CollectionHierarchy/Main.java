package CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputStrings = scanner.nextLine().split("\\s+");
        int amountOfRemoveOperations = Integer.parseInt(scanner.nextLine());


        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myListImpl = new MyListImpl();

        for (String str : inputStrings) {
            System.out.print(addCollection.add(str) + " ");
        }

        System.out.println();

        for (String str : inputStrings) {
            System.out.print(addRemoveCollection.add(str) + " ");
        }


        System.out.println();
        for (String str : inputStrings) {
            System.out.print(myListImpl.add(str) + " ");
        }

        System.out.println();

        for (int i = 0; i < amountOfRemoveOperations; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }

        System.out.println();
        for (int i = 0; i < amountOfRemoveOperations; i++) {
            System.out.print(myListImpl.remove() + " ");
        }

    }
}
