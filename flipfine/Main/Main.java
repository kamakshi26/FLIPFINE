package Main;

import java.util.HashMap;

import DataLayer.DocManager;
import DataLayer.PatientManager;
import Model.Doctor;
import Model.Patient;
import Model.Slot;
import Model.Specialization;
import Services.AppointmentServ;
import Services.DocServ;
import Services.PatientServ;

public class Main {
    public static void main(String[] args) {
        
                DocManager docManager=new DocManager();
                PatientManager patientManager=new PatientManager();
                DocServ docServ=new DocServ(docManager);
                PatientServ patientServ=new PatientServ(patientManager);
                AppointmentServ appointmentServ=new AppointmentServ(docManager, patientManager);


                Doctor curious = new Doctor(1, "curious", new HashMap<>(), Specialization.CARDIOLOGIST);
                Doctor dreadful = new Doctor(2, "dreadful", new HashMap<>(), Specialization.DERMATOLOGIST);
                Doctor daring = new Doctor(3, "daring", new HashMap<>(), Specialization.DERMATOLOGIST);

                Patient patientA = new Patient(1, "patientA");
                Patient patientB = new Patient(2, "patientB");
                Patient patientC = new Patient(3, "patientC");

                //add doc

                docServ.addDoctor(curious);
                docServ.addDoctor(daring);
                docServ.addDoctor(dreadful);

                //add wrong availability

                docServ.addFreeTimeForDoctor(curious.getDocId(), new Slot("9:30", "10:30"));
               

                //add valid ones

                docServ.addFreeTimeForDoctor(curious.getDocId(), new Slot("9:30", "10:00"));
                docServ.addFreeTimeForDoctor(curious.getDocId(), new Slot("12:30", "13:00"));
                docServ.addFreeTimeForDoctor(curious.getDocId(), new Slot("16:00", "16:30"));
                docServ.addFreeTimeForDoctor(dreadful.getDocId(), new Slot("12:30", "13:00"));

                docServ.displayFreeSlotsForSpecialisedDocs(Specialization.CARDIOLOGIST);

                patientServ.addPatient(patientA);
                patientServ.addPatient(patientB);
                patientServ.addPatient(patientC);

                appointmentServ.bookAppointment(patientA, curious, "12:30");

                docServ.displayFreeSlotsForSpecialisedDocs(Specialization.CARDIOLOGIST);

                appointmentServ.bookAppointment(patientB, curious, "12:30");
                appointmentServ.bookAppointment(patientC, curious, "12:30");

              appointmentServ.displayBookedAppointments();  

              appointmentServ.cancelBooking(1);

              

    }
}
