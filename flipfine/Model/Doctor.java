package Model;

import java.util.Map;

public class Doctor{
    int docId;
    String docName;
    Map<Slot,Boolean> timeSlots;
    Specialization specialization;
    int rating;

    
    public Doctor(int docId, String docName, Map<Slot, Boolean> timeSlots, Specialization specialization) {
        this.docId = docId;
        this.docName = docName;
        this.timeSlots = timeSlots;
        this.specialization = specialization;
    }
    public int getDocId() {
        return docId;
    }
    public void setDocId(int docId) {
        this.docId = docId;
    }
    public String getDocName() {
        return docName;
    }
    public void setDocName(String docName) {
        this.docName = docName;
    }
    public Map<Slot, Boolean> getTimeSlots() {
        return timeSlots;
    }
    public void setTimeSlots(Map<Slot, Boolean> timeSlots) {
        this.timeSlots = timeSlots;
    }
    public Specialization getSpecialization() {
        return specialization;
    }
    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    @Override
    public String toString() {
        return "Doctor [docId=" + docId + ", docName=" + docName + ", timeSlots=" + timeSlots + ", specialization="
                + specialization + "]";
    }

    
}