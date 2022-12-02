package AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
       setName(name);
       setAge(age);
    }



    public double productPerDay() {
        return calculateProductPerDaY();
    }

    private double calculateProductPerDaY() {
        double producedEggs = 0;
        if(age >= 0 && age <= 5) {
            producedEggs = 2;
        } else if(age >= 6 && age <= 11) {
            producedEggs = 1;
        } else {
            producedEggs = 0.75;
        }

        return  producedEggs;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                getName(),
                getAge(),
                productPerDay()
        );
    }

    private void setName(String name) {
        if(name.length() < 1 || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if(age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
