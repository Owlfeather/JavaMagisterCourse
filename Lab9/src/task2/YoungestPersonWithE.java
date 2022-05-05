package task2;

import java.util.*;

enum Sex {
    MAN,
    WOMAN
}

class People {
    private String name;
    private Integer age;
    private Sex sex;

    public People(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age && Objects.equals(name, people.name) && sex == people.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                "} \n";
    }
}

public class YoungestPersonWithE {
    public static void main(String[] args) {

        Collection<People> peoples = Arrays.asList(
                new People("Ivan", 16, Sex.MAN),
                new People("Petr", 23, Sex.MAN),
                new People("Stepan", 18, Sex.MAN),
                new People("Maria", 42, Sex.WOMAN)
        );

        System.out.println("Collection: ");
        System.out.println(peoples);
        People min_with_e = peoples.stream().filter(s -> s.getName().toLowerCase(Locale.ROOT).contains("e")).min(Comparator.comparingInt(People::getAge)).get();
        System.out.println("Youngest person with e letter:");
        System.out.println(min_with_e);
    }
}
