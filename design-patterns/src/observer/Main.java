package observer;

public class Main {
    public static void main(String[] args) {
        Observer carFan1 = new CarFan();
        Observer carFan2 = new CarFan();
        Observer carFan3 = new CarFan();

        Subject topGear = new TopGear();

        topGear.registerObserver(carFan1);
        topGear.registerObserver(carFan2);
        topGear.registerObserver(carFan3);

        topGear.notifyObservers("First edition");
        topGear.notifyObservers("Second edition");
    }
}
