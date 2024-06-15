package Model;

import java.util.Objects;

public class Slot {

    String begin;
    String end;

    
    public Slot(String begin, String end) {
        this.begin = begin;
        this.end = end;
    }
    public String getBegin() {
        return begin;
    }
    public void setBegin(String begin) {
        this.begin = begin;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        Slot timeSlot=(Slot) obj;
        return begin.equals(timeSlot.begin) && end.equals(timeSlot.end);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hash(begin,end);
    }
    @Override
    public String toString() {
        return "Slot [begin=" + begin + ", end=" + end + "]";
    }

    
}
