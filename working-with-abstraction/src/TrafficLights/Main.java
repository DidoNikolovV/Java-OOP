package TrafficLights;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> lights = new ArrayDeque<>();

        for(String el: input) {
            lights.offer(el);
        }
        int n = Integer.parseInt(scanner.nextLine());

        int size = lights.size();
        while(n-- > 0) {
            for(int i = 0; i < size; i++) {
                String currentLight = lights.pop();
                TrafficLight trafficLight = TrafficLight.valueOf(currentLight);
                System.out.print(trafficLight.getLight() + " ");
                lights.offer(trafficLight.getLight());
            }
            System.out.println();
        }
    }
}
