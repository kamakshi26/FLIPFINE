package DataLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Doctor;
import Model.FreeDoctors;
import Model.Slot;
import Model.Specialization;

public class DocManager {

    Map<Integer,Doctor> doctorsList = new HashMap<>();
    Map<Specialization,List<Doctor>> docVsSpecialization = new HashMap<>();


    public void addDoctor(Doctor doc){
        if(doctorsList.containsKey(doc.getDocId())){
            System.out.println("Doctor already Present");
            return;
        }

        doctorsList.put(doc.getDocId(), doc);

        if(!docVsSpecialization.containsKey(doc.getSpecialization())){
            docVsSpecialization.put(doc.getSpecialization(), new ArrayList<>());
        }

        docVsSpecialization.get(doc.getSpecialization()).add(doc);
    }


    public void addAvailableTime(int docId,Slot timeSlot){
        if(!doctorsList.containsKey(docId)){
            System.out.println("doctor not present");
            return;
        }

        Doctor doc = doctorsList.get(docId);
        Map<Slot,Boolean> slots = doc.getTimeSlots();
        slots.put(timeSlot,true);
        doctorsList.put(docId, doc);
    }


    public List<Doctor> getSpecialityDocs(Specialization spec){
        if(!docVsSpecialization.containsKey(spec)){
            System.out.println("this specialization doc not present");
            return new ArrayList<>();
        }

        return docVsSpecialization.get(spec);
    }

    public boolean isDoctorAdded(int docId){
        return doctorsList.containsKey(docId);
    }

    public void getAvailableSlots(int docId,Slot timeSlot){
        Boolean temp=doctorsList.get(docId).getTimeSlots().put(timeSlot, true);
            if(temp==null){
                doctorsList.get(docId).getTimeSlots().remove(timeSlot);
                System.out.println("slot not available");
                return;
            }
    }

    public Doctor getDocInfo(int docId){
        return doctorsList.get(docId);
    }

    public List<FreeDoctors> getFreeDoctorTimeForSpecialisation(List<Doctor> specDoctors){

        List<FreeDoctors> availableDocList = new ArrayList<>();

        for(Doctor doc:specDoctors){
            FreeDoctors freeDoctor = new FreeDoctors();
            freeDoctor.setDoc(doc);
            List<Slot> freeSlots = new ArrayList<>();
            Map<Slot,Boolean> timeSlots = doc.getTimeSlots();

            for(Map.Entry<Slot,Boolean> entry:timeSlots.entrySet()){
                if(entry.getValue()){
                       freeSlots.add(entry.getKey());             
                }
            }
            freeDoctor.setAvailableSlots(freeSlots);
            availableDocList.add(freeDoctor);
        }
        return availableDocList;
    }
    
}
