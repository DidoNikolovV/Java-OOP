package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while(!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            identifiables.add(
                    tokens.length == 2
                            ? new Robot(tokens[1], tokens[0])
                            : new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2])

            );

            line = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();

        identifiables.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeId))
                .forEach(System.out::println);
    }
}
