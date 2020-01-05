package ie.cit.hotelmanagement.service;

import ie.cit.hotelmanagement.model.Guest;
import ie.cit.hotelmanagement.repository.GuestRepository;

import java.util.ArrayList;

public class GuestService {

    GuestRepository guestRepository;

    public GuestService(){
        guestRepository = GuestRepository.getInstance();
    }
    public void addGuest(Guest guest){
        guestRepository.addGuest(guest);
    }
    public void removeGuest(Guest guest){
        guestRepository.removeGuest(guest);
    }
    public ArrayList<Guest> findAllGuest(){
        return guestRepository.findAllGuests();
    }
}
