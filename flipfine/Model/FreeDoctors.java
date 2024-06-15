package Model;

import java.util.List;

public class FreeDoctors {
    Doctor doc;
    List<Slot> availableSlots;
    public Doctor getDoc() {
        return doc;
    }
    public void setDoc(Doctor doc) {
        this.doc = doc;
    }
    public List<Slot> getAvailableSlots() {
        return availableSlots;
    }
    public void setAvailableSlots(List<Slot> availableSlots) {
        this.availableSlots = availableSlots;
    }
    @Override
    public String toString() {
        return "FreeDoctors [doc=" + doc + ", availableSlots=" + availableSlots + "]";
    }

    
    
}
