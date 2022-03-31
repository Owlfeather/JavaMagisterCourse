package task2;

import java.util.ArrayList;

public class MainForPatient {
    public static void main(String[] args) {

        Patient[] patientsArray = new Patient[0];
        try {
            patientsArray = createPatientsArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Patients:");
        for (Patient p: patientsArray) {
            System.out.println(p);
        }

        Patient[] patientsWithDiabetes = chooseByDiagnosis(patientsArray, "Diabetes");
        System.out.println();
        System.out.println("Patients with Diabetes:");
        for (Patient p: patientsWithDiabetes) {
            System.out.println(p);
        }
        Patient[] patientsInRange = chooseByCardNumber(patientsArray, 130, 140);
        System.out.println();
        System.out.println("Patients with CardNumbers in range 130...140:");
        for (Patient p: patientsInRange) {
            System.out.println(p);
        }
    }

    private static Patient[] createPatientsArray() throws Exception {
        Patient p1 = new Patient(1,"Ivan", "Ivanov", "Ivanovich", "House 5", "8-968-374-26-47", 132, "Diabetes");
        Patient p2 = new Patient(2,"Petr", "Petrov", "Petrovich", "House 3", "8-969-375-27-74", 148, "COVID-19");
        Patient p3 = new Patient(3,"Dmitry", "Smirnov", "Ivanovich", "House 9", "8-977-234-86-07", 119, "Diabetes");
        Patient p4 = new Patient(4,"Ivan", "Smirnov", "Andreevich", "House 5", "8-978-306-36-43", 135, "COVID-19");
        Patient p5 = new Patient(5,"Alexander", "Ivanov", "Ilich", "House 11", "8-961-333-28-17", 138, "Flu");
        return new Patient[]{p1, p2, p3, p4, p5};
    }

    private static Patient[] chooseByDiagnosis(Patient[] patientsArray, String diagnosis){
        ArrayList<Patient> newPatientsArray = new ArrayList<>();
        for (int i = 0; i < patientsArray.length; i++) {
            if(patientsArray[i].getDiagnosis().equals(diagnosis)){
                newPatientsArray.add(patientsArray[i]);
            }
        }
        return (Patient[]) newPatientsArray.toArray(new Patient[newPatientsArray.size()]);
    }

    private static Patient[] chooseByCardNumber(Patient[] patientsArray, int startBound, int endBound){
        ArrayList<Patient> newPatientsArray = new ArrayList<>();
        for (int i = 0; i < patientsArray.length; i++) {
            if(patientsArray[i].getCardNumber() >= startBound && patientsArray[i].getCardNumber() <= endBound){
                newPatientsArray.add(patientsArray[i]);
            }
        }
        return (Patient[]) newPatientsArray.toArray(new Patient[newPatientsArray.size()]);
    }
}
