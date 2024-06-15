package Services;

import DataLayer.PatientManager;
import Model.Patient;

public class PatientServ {

    PatientManager patientManager;

    public PatientServ(PatientManager patientManager) {
        this.patientManager = patientManager;
    }

    public void addPatient(Patient patient){
        patientManager.addPatient(patient);
        System.out.println("patient added!!");
    }
    
    
}
