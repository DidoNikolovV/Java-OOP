package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.parse(input[2]);
        Discount discountType = Discount.parse(input[3]);

        PriceCalculator calculator = new PriceCalculator(pricePerDay, days, season, discountType);
        double result = calculator.calculatePrice();
        System.out.printf("%.2f", result);


    }
}
