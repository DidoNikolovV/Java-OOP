package CardsWithPower;

public class Card {
    RankPowers rankPower;
    SuitPowers suitPower;

    public Card(RankPowers rankPower, SuitPowers suitPower) {
        this.rankPower = rankPower;
        this.suitPower = suitPower;
    }

    public int calculatePower() {
        return rankPower.getRankPower() + suitPower.getSuitPower();
    }

    public RankPowers getRankPower() {
        return rankPower;
    }

    public SuitPowers getSuitPower() {
        return suitPower;
    }
}
