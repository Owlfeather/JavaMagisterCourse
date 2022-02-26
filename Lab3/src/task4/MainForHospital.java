package task4;

public class MainForHospital {
    public static void main(String[] args) {

        Hospital hospital = new Hospital();

        Patient pat1 = new Patient("Ivanov Petr Semenovich", 1);
        Patient pat2 = new Patient("Smirnov Ivan Andreevich", 2);
        Patient pat3 = new Patient("Semakov Andrey Ivanovich", 3);

        Staff doc1 = new Staff(1, "Troshin Mikhail Dmitrievich", "Doctor");
        Staff doc2 = new Staff(2, "Mikhailova Maria Maximovna", "Doctor");
        Staff nurse = new Staff(3, "Zimina Natalia Andreevna", "Nurse");

        hospital.addPatient(pat1);
        hospital.addPatient(pat2);
        hospital.addPatient(pat3);

        hospital.addStaff(doc1);
        hospital.addStaff(doc2);
        hospital.addStaff(nurse);

        hospital.setDoctor(pat1.getId(), doc1.getId());
        hospital.setDoctor(pat2.getId(), doc2.getId());
        hospital.setDoctor(pat3.getId(), doc2.getId());

        System.out.println();
        System.out.println("Doctors and patients: ");
        System.out.println(hospital);

        Assignment a1 = new Assignment();
        a1.addDrug("Nurofen");
        a1.addDrug("Sinupret");
        a1.addDrug("Coldrex");
        a1.addDrug("Tantum Verde");
        a1.addProcedure("Inhalation");
        hospital.setAssignment(pat1.getId(), a1);

        Assignment a2 = new Assignment();
        a2.addSurgery("Laser birthmark removal");
        a2.addDrug("Panthenol");
        hospital.setAssignment(pat2.getId(), a2);

        Assignment a3 = new Assignment();
        a3.addProcedure("Back massage");
        a3.addProcedure("Swimming pool");
        a3.addDrug("Vitamin D");
        hospital.setAssignment(pat3.getId(), a3);

        System.out.println();
        System.out.println("Patients with assignments: ");
        System.out.println(hospital);

        hospital.completeAssignment(pat1.getId(), doc2.getId());
        hospital.completeAssignment(pat2.getId(), nurse.getId());
        hospital.completeAssignment(pat3.getId(), nurse.getId());

        System.out.println();
        System.out.println("Patients with done assignments: ");
        System.out.println(hospital);

        hospital.dismissPatient(pat1, "End of treatment");
        hospital.dismissPatient(pat2, "End of treatment");
        hospital.dismissPatient(pat3, "Transferred to another department for treatment");

        System.out.println();
        System.out.println("Patients are dismissed: ");
        System.out.println(hospital);

    }
}
