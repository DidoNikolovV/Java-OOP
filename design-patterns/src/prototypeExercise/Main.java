package prototypeExercise;



public class Main {
    public static void main(String[] args) {
        EmployeeRecord pesho = new EmployeeRecord(1, "pesho", "more", 150, "Ruse");
        Prototype pesho1 = pesho.getClone();
        pesho.showRecord();
    }
}
