package task4;

import java.util.ArrayList;
import java.util.Objects;

public class Assignment {
    private ArrayList<String> procedures;
    private ArrayList<String> drugs;
    private ArrayList<String> surgeries;
    private boolean done;

    public Assignment() {
        this.procedures = new ArrayList<>();
        this.drugs = new ArrayList<>();
        this.surgeries = new ArrayList<>();
        this.done = false;
    }

    public void addProcedure(String proc){
        this.procedures.add(proc);
    }

    public void addDrug(String drug){
        this.drugs.add(drug);
    }

    public void addSurgery(String surg){
        this.surgeries.add(surg);
    }

    public void complete(){
        this.done = true;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "procedures=" + procedures +
                ", drugs=" + drugs +
                ", surgeries=" + surgeries +
                ", done=" + done +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return done == that.done && Objects.equals(procedures, that.procedures) && Objects.equals(drugs, that.drugs) && Objects.equals(surgeries, that.surgeries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(procedures, drugs, surgeries, done);
    }
}
