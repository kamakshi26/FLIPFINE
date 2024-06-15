package Model;

import java.util.List;
import java.util.Map;

public class Patient {
    int patientId;
    String patientName;
    Map<Doctor,List<Slot>> bookedTimeSlots;
    public Patient(int patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
    }
    public int getPatientId() {
        return patientId;
    }
    public String getPatientName() {
        return patientName;
    }
    public Map<Doctor, List<Slot>> getBookedTimeSlots() {
        return bookedTimeSlots;
    }
    public void setBookedTimeSlots(Map<Doctor, List<Slot>> bookedTimeSlots) {
        this.bookedTimeSlots = bookedTimeSlots;
    }
    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", bookedTimeSlots="
                + bookedTimeSlots + "]";
    }

    
}
