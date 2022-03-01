package task2;

public class ExtramuralStudent extends Student{

    String typeOfExtramuralEducation;

    public ExtramuralStudent() {
    }

    public ExtramuralStudent(String name, String group, String typeOfExtramuralEducation) {
        super(name, group);
        this.typeOfExtramuralEducation = typeOfExtramuralEducation;
    }

    public String getTypeOfExtramuralEducation() {
        return typeOfExtramuralEducation;
    }

    public void setTypeOfExtramuralEducation(String typeOfExtramuralEducation) {
        this.typeOfExtramuralEducation = typeOfExtramuralEducation;
    }

    @Override
    public String toString() {
        return "ExtramuralStudent{" +
                "typeOfExtramuralEducation='" + typeOfExtramuralEducation +
                super.toString() + '\'' +
                '}';
    }
}
