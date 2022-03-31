package task2;

import java.util.regex.Pattern;

public class Patient {
    private  int id;
    private String name;
    private String surname;
    private String lastname;
    private String address;
    private String phone;
    private int cardNumber;
    private String diagnosis;

    public Patient() {
    }

    public Patient(int id, String name, String surname, String lastname, String address, String phone, int cardNumber, String diagnosis) throws Exception {
        if (id < 0) {
            throw new Exception("Patient exception : wrong id!");
        }
        if ((cardNumber < 100) || (cardNumber > 999)) {
            throw new Exception("Patient exception : wrong card number!");
        }
        if ((name.equals("")) || (surname.equals("")) || (lastname.equals(""))) {
            throw new Exception("Patient exception : empty name/surname/lastname!");
        }
        if (!Pattern.matches("^8-9\\d{2}-\\d{3}-\\d{2}-\\d{2}", phone)) {
            throw new Exception("Patient exception : wrong phone number!");
        }
        if (diagnosis.equals("")) {
            throw new Exception("Patient exception : no diagnosis!");
        }

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.cardNumber = cardNumber;
        this.diagnosis = diagnosis;
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

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", cardNumber=" + cardNumber +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
