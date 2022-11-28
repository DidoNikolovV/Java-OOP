package pointRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = Integer.parseInt(scanner.nextLine());

        Point A = new Point(coordinates[0], coordinates[1]);
        Point C = new Point(coordinates[2], coordinates[3]);

        Rectangle rect = new Rectangle(A, C);

        while(n-- > 0) {
            int[] currentPointCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int x = currentPointCoordinates[0];
            int y = currentPointCoordinates[1];
            Point point = new Point(x, y);
            System.out.println(rect.contains(point));
        }
    }
}
