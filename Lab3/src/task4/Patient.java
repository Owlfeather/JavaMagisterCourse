package task4;

import java.util.Objects;

public class Patient {
    private String name;
    private int id;
    private boolean inHospital;
    private String reason;

    public Patient() {
    }

    public Patient(String name, int id ) {
        this.name = name;
        this.id = id;
        this.inHospital = true;
        this.reason = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInHospital() {
        return inHospital;
    }

    public void setInHospital(boolean inHospital) {
        this.inHospital = inHospital;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void dismiss(String reason){
        this.inHospital = false;
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id && inHospital == patient.inHospital && Objects.equals(name, patient.name) && Objects.equals(reason, patient.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, inHospital, reason);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", inHospital=" + inHospital +
                ", reason='" + reason + '\'' +
                '}';
    }
}
