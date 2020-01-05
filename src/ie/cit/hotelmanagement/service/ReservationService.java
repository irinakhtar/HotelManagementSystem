package ie.cit.hotelmanagement.service;

import ie.cit.hotelmanagement.model.Guest;
import ie.cit.hotelmanagement.model.Room;
import ie.cit.hotelmanagement.repository.GuestRepository;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    GuestRepository guestRepository;

    public ReservationService(){
        guestRepository = GuestRepository.getInstance();
    }
    public void addReservation(Guest guest, Room room){
        room.setGuest(guest);
    }
    public void cancelReservation(Room room){
        if (room != null) {
            room.setGuest(null);
        }
    }
    public Guest viewReservation(String name, String phone){
        ArrayList<Guest> allGuest = guestRepository.findAllGuests();
        for(Guest guest:allGuest){
            if(guest.getName().equalsIgnoreCase(name) && guest.getPhoneNumber().equalsIgnoreCase(phone)){
                return guest;
            }
        }
        return null;
    }

    public void receivePayment(List<Room> rooms) {
        for (Room room : rooms) {
            System.out.println("Room type=" + room.getRoomType() + ", Payment received=" + room.getRate());
        }
    }
}
