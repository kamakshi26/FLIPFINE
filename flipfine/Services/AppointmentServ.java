package Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import DataLayer.DocManager;
import DataLayer.PatientManager;
import Model.AppointmentBooking;
import Model.Doctor;
import Model.Patient;
import Model.Slot;

public class AppointmentServ {
    DocManager docManager;
    PatientManager patientManager;
    Map<Integer,AppointmentBooking> bookings = new HashMap<>();
    Map<Integer,List<Slot>> patientSlotList = new HashMap<>();
    Queue<AppointmentBooking> waitingList= new LinkedList<>();

    static int i=1;

    public AppointmentServ(DocManager docManager, PatientManager patientManager) {
        this.docManager = docManager;
        this.patientManager = patientManager;
    }

    public void bookAppointment(Patient patient,Doctor doc,String fromTime){
        if(!patientManager.isPatientAdded(patient.getPatientId())){
            System.out.println("patient not present!!");
            return;
        }

        if(!docManager.isDoctorAdded(doc.getDocId())){
            System.out.println("doctor not present!!");
            return;
        }

        //already booked ?

        if(patientSlotList.containsKey(patient.getPatientId())){
            for(Slot timSlot:patientSlotList.get(patient.getPatientId())){
                if(timSlot.getBegin().equals(fromTime)){
                    System.out.println("patient already occupied!!");
                    return;
                }
            }
        }else{
            patientSlotList.put(patient.getPatientId(), new ArrayList<>());
        }

            //doc avail?

            Doctor docDetails = docManager.getDocInfo(doc.getDocId());
            Map<Slot,Boolean> slots = docDetails.getTimeSlots();

            for(Map.Entry<Slot,Boolean> slot:slots.entrySet()){
                if(slot.getKey().getBegin().equals(fromTime) && slot.getValue()){
                slots.put(slot.getKey(), false);
                patientSlotList.get(patient.getPatientId()).add(slot.getKey());
                AppointmentBooking booking=new AppointmentBooking(i++, doc, patient, slot.getKey());
                bookings.put(booking.getAppointmentId(), booking);

                System.out.println("appointment booked for booking id -> "+booking.getAppointmentId());
                return;
            }
        }

        System.out.println("no available slots");

        AppointmentBooking booking=new AppointmentBooking(i++, doc, patient, new Slot(fromTime, fromTime));
        booking.setWaitingList(true);
        System.out.println("added to wait list booking id= "+booking.getAppointmentId());
        waitingList.add(booking);
    }

        public void cancelBooking(int bookindId){
            if(!bookings.containsKey(bookindId)){
                System.out.println("booking not present!");
                return;
            }

            AppointmentBooking booking=bookings.get(bookindId);
            docManager.addAvailableTime(booking.getBookedDoc().getDocId(), booking.getTimeSlot());
            bookings.remove(bookindId);
            System.out.println("booking cancelled!");
            patientSlotList.get(booking.getBookedPatient().getPatientId()).remove(booking.getTimeSlot());
            checkFreeSlot(booking);
        }

        private void checkFreeSlot(AppointmentBooking booking) {
           for(AppointmentBooking waitListBooking:waitingList){
                if(waitListBooking.getTimeSlot().getBegin().equals(booking.getTimeSlot().getBegin())){
                    waitListBooking.getTimeSlot().setEnd(booking.getTimeSlot().getEnd());
                    waitListBooking.setWaitingList(false);

                    Doctor docDetails = docManager.getDocInfo(waitListBooking.getBookedDoc().getDocId());
                    Map<Slot,Boolean> slots=docDetails.getTimeSlots();

                    for(Map.Entry<Slot,Boolean> slot:slots.entrySet()){
                        if(slot.getKey().getBegin().equals(booking.getTimeSlot().getBegin())){
                            slots.put(slot.getKey(), false);
                            break;
                        }
                    }

                    bookings.put(waitListBooking.getAppointmentId(), waitListBooking);
                    waitingList.remove(waitListBooking);
                    return;
                }
           }
        }

        public void displayBookedAppointments(){
            for(Map.Entry<Integer,AppointmentBooking> entry:bookings.entrySet()){
                AppointmentBooking booking=entry.getValue();
                System.out.println("booking id - "+booking.getAppointmentId());
                System.out.println("doc name - "+booking.getBookedDoc());
                System.out.println("patient name- "+booking.getBookedPatient());
                System.out.println("booking slot - "+booking.getTimeSlot());
                
            }
        }

        

    
}
