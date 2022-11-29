package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RankPowers cardRank = RankPowers.valueOf(scanner.nextLine());
        SuitPowers suitPower = SuitPowers.valueOf(scanner.nextLine());
        Card card = new Card(cardRank, suitPower);

        System.out.printf("Card name: %s of %s; Card power: %d", card.getRankPower(), card.getSuitPower(), card.calculatePower());
    }
}
