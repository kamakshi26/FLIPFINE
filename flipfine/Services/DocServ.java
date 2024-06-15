package Services;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import DataLayer.DocManager;
import Model.Doctor;
import Model.FreeDoctors;
import Model.Slot;
import Model.Specialization;

public class DocServ {
    DocManager docManager;

    public DocServ(DocManager docManager) {
        this.docManager = docManager;
    }

    public void addDoctor(Doctor doc){
        docManager.addDoctor(doc);
        System.out.println("doctor added!!");
    }

    public void addFreeTimeForDoctor(int docId,Slot timeSlot){

        String starttime[]=timeSlot.getBegin().split(":");

        LocalTime begin = LocalTime.of(Integer.parseInt(starttime[0]),Integer.parseInt(starttime[1]));
        String endTime[] = timeSlot.getEnd().split(":");
        
        LocalTime end = LocalTime.of(Integer.parseInt(endTime[0]),Integer.parseInt(endTime[1]));
        
        if(ChronoUnit.MINUTES.between(begin, end)%60==30){
            docManager.addAvailableTime(docId, timeSlot);
            System.out.println("availability added!!");
        }else{
                System.out.println("slot time is only 30 mins ");
        }
    }

    public void displayFreeSlotsForSpecialisedDocs(Specialization specialization){
        List<Doctor> docVsSpecialization=docManager.getSpecialityDocs(specialization);
        List<FreeDoctors> freeTimeSlots=docManager.getFreeDoctorTimeForSpecialisation(docVsSpecialization);

        if(freeTimeSlots.size()>0){
            System.out.println("available doctors with their time slots");

            for(FreeDoctors fDoctors:freeTimeSlots){
                for(Slot timeSlot:fDoctors.getAvailableSlots()){
                    System.out.println(fDoctors.getDoc().getDocName()+"---"+timeSlot.getBegin()+" to "+timeSlot.getEnd());
                }
            }
        }else{
            System.out.println("no available slots present!!!");
        }
    }

}
