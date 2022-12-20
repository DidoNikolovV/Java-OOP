package Telephony;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> urls = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(numbers, urls);

        for (String number : numbers) {
            if(number.matches("^[0-9]*$")){
                System.out.println(smartphone.call() + number);
            } else {
                System.out.println("Invalid number!");
            }
        }

        for(String url : urls) {
            if(url.matches(".*\\d+.*")){
                System.out.println("Invalid URL!");
            } else {
                System.out.println(smartphone.browse() + url + "!");
            }
        }


    }
}
