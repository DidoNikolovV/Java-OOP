package builderExercise.builderExample;


public class Main {
    public static void main(String[] args) {
        Person person = Person
                .builder()
                .withLastName("Petrov")
                .withAddress("Burgas")
                .build();

    }
}
