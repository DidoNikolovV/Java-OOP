package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimensions = getCoordinates(scanner.nextLine());
            int rows = dimensions[0];
            int cols = dimensions[1];

            int[][] galaxy = new int[rows][cols];

        fillInGalaxy(rows, cols, galaxy);

        String command = scanner.nextLine();
            long collectedStars = 0;
            while (!command.equals("Let the Force be with you"))
            {
                int[] jediStartingCoordinates = getCoordinates(command);
                int[] evilStartingCoordinates = getCoordinates(scanner.nextLine());
                int currentEvilRow = evilStartingCoordinates[0];
                int currentEvilCol = evilStartingCoordinates[1];

                while (currentEvilRow >= 0 && currentEvilCol >= 0) {
                    if (isInBounds(galaxy, currentEvilRow, currentEvilCol)) {
                        galaxy[currentEvilRow] [currentEvilCol] = 0;
                    }
                    currentEvilRow--;
                    currentEvilCol--;
                }

                int currentJediRow = jediStartingCoordinates[0];
                int currentJediCol = jediStartingCoordinates[1];

                while (currentJediRow >= 0 && currentJediCol < galaxy[1].length)
                {
                    if (isInBounds(galaxy, currentJediRow, currentJediCol))
                    {
                        collectedStars += galaxy[currentJediRow][currentJediCol];
                    }

                    currentJediCol++;
                    currentJediRow--;
                }

                command = scanner.nextLine();
            }

        System.out.println(collectedStars);


    }

    private static boolean isInBounds(int[][] galaxy, int currentJediRow, int currentJediCol) {
        return currentJediRow < galaxy.length && currentJediCol >= 0 && currentJediCol < galaxy[0].length;
    }

    private static int[] getCoordinates(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void fillInGalaxy(int rows, int cols, int[][] galaxy) {
        int value = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                galaxy[i][j] = value++;
            }
        }
    }
}
