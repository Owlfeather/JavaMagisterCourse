package task2;

import java.util.HashMap;

public abstract class Student implements Abiturient{

    private String name;
    private String group;
    private HashMap<String, Integer> subjectScores;

    public Student() {
        subjectScores = new HashMap<>();
    }

    public Student(String name, String group) {
        this.name = name;
        this.group = group;
        subjectScores = new HashMap<>();
    }

    public void addSubject(String subject){
        subjectScores.put(subject, 0);
    }

    public void addPoints(String subject, int points){
        subjectScores.put(subject, subjectScores.get(subject) + points);
    }

    @Override
    public void passExam(String subject, int score) {
        int pointsPerSemester  = subjectScores.get(subject);
        if (score < 18 || (pointsPerSemester + score) < 60){
            System.out.println(subject + " exam is not passed by " + name + "!");
        } else {
            subjectScores.put(subject, subjectScores.get(subject) + score);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public HashMap<String, Integer> getSubjectScores() {
        return subjectScores;
    }

    public void setSubjectScores(HashMap<String, Integer> subjectScores) {
        this.subjectScores = subjectScores;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", subjectScores=" + subjectScores
                ;
    }
}
