package DataLayer;

import java.util.HashMap;
import java.util.Map;

import Model.Patient;

public class PatientManager {
    Map<Integer,Patient> patients = new HashMap<>();

    public void addPatient(Patient patient){
        if(patients.containsKey(patient.getPatientId())){
            System.out.println("patient already present");
            return;
        }
        patients.put(patient.getPatientId(), patient);
    }


    public boolean isPatientAdded(int patientId){
        return patients.containsKey(patientId);
    }
}
