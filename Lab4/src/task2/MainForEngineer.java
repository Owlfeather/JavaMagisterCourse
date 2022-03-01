package task2;

public class MainForEngineer {
    public static void main(String[] args) {

        Engineer engineer = new Engineer("Ivanov Ivan Ivanovich", "process engineer", "NII CHAVO", "Magic");
        Head head = new Head("Petrov Petr Petrovich", "main engineer", "NII CHAVO", "Magic");

        System.out.println(engineer.introduce());
        System.out.println();
        System.out.println(head.introduce());
    }
}
