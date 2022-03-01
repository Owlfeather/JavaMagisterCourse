package task2;

public class MainForStudent {
    public static void main(String[] args) {

        ExtramuralStudent exSt1 = new ExtramuralStudent("Ivanov Maxim Andreevich", "ICS6-13", "Moduled");
        ExtramuralStudent exSt2 = new ExtramuralStudent("Smirnova Ekaterina Ivanovna", "ICS5-11", "Classic");

        exSt1.addSubject("Mathematics");
        exSt1.addPoints("Mathematics", 59);
        exSt1.addSubject("History");
        exSt1.addPoints("History", 55);

        exSt2.addSubject("Mathematics");
        exSt2.addPoints("Mathematics", 60);
        exSt2.addSubject("History");
        exSt2.addPoints("History", 53);

        System.out.println("Before exams:");
        System.out.println(exSt1);
        System.out.println(exSt2);

        System.out.println();
        System.out.println("After exams:");
        exSt1.passExam("Mathematics", 29);
        exSt1.passExam("History", 12);
        exSt2.passExam("Mathematics", 25);
        exSt2.passExam("History", 23);

        System.out.println(exSt1);
        System.out.println(exSt2);

    }
}
