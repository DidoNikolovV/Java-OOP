package singleton.ZooExample;

public class Employee {
    public void feedAnimals() {
        // iterate over all animals and feed them
        Zoo.getInstance().getAnimals().keySet().forEach(k -> System.out.println("Feeding animal " + k));
    }
}
