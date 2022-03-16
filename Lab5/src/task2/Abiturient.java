package task2;

import java.util.ArrayList;
import java.util.regex.*;

public class Abiturient {
    private  int id;
    private String name;
    private String surname;
    private String lastname;
    private String address;
    private String phone;
    private ArrayList<Integer> marks;

    public Abiturient() {
    }

    public Abiturient(int id, String name, String surname, String lastname, String address, String phone, ArrayList<Integer> marks) throws Exception {
        if (id < 0) {
            throw new Exception("Abiturient exception : wrong id!");
        }
        if ((name.equals("")) || (surname.equals("")) || (lastname.equals(""))) {
            throw new Exception("Abiturient exception : empty name/surname/lastname!");
        }
        if (!Pattern.matches("^8-9\\d{2}-\\d{3}-\\d{2}-\\d{2}", phone)) {
            throw new Exception("Abiturient exception : wrong phone number!");
        }
        for(int x : marks){
            if((x < 2) || (x > 5)){
                throw new Exception("Abiturient exception : wrong mark number!");
            }
        }
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Abiturient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", marks=" + marks +
                '}';
    }
}
