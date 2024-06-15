package Model;

public class AppointmentBooking {
    int appointmentId;
    Doctor bookedDoc;
    Patient bookedPatient;
    Slot timeSlot;
    Boolean waitingList;
    public AppointmentBooking(int appointmentId, Doctor bookedDoc, Patient bookedPatient, Slot timeSlot
            ) {
        this.appointmentId = appointmentId;
        this.bookedDoc = bookedDoc;
        this.bookedPatient = bookedPatient;
        this.timeSlot = timeSlot;
       
    }
    public int getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    public Doctor getBookedDoc() {
        return bookedDoc;
    }
    public void setBookedDoc(Doctor bookedDoc) {
        this.bookedDoc = bookedDoc;
    }
    public Patient getBookedPatient() {
        return bookedPatient;
    }
    public void setBookedPatient(Patient bookedPatient) {
        this.bookedPatient = bookedPatient;
    }
    public Slot getTimeSlot() {
        return timeSlot;
    }
    public void setTimeSlot(Slot timeSlot) {
        this.timeSlot = timeSlot;
    }
    public Boolean getWaitingList() {
        return waitingList;
    }
    public void setWaitingList(Boolean waitingList) {
        this.waitingList = waitingList;
    }
    @Override
    public String toString() {
        return "AppointmentBooking [appointmentId=" + appointmentId + ", bookedDoc=" + bookedDoc + ", bookedPatient="
                + bookedPatient + ", timeSlot=" + timeSlot + ", waitingList=" + waitingList + "]";
    }

    
}
