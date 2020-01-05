package ie.cit.hotelmanagement.repository;

import ie.cit.hotelmanagement.model.Guest;

import java.util.ArrayList;

public class GuestRepository {

    private static GuestRepository guestRepository;

    private ArrayList<Guest> guests;

    private GuestRepository(){
        guests = new ArrayList<>();
    }
    public static GuestRepository getInstance(){
        if(guestRepository == null){
            guestRepository = new GuestRepository();
        }
        return guestRepository;
    }
    public void addGuest(Guest guest){
        guests.add(guest);
    }
    public void removeGuest(Guest guest){
        guests.remove(guest);
    }
    public ArrayList<Guest> findAllGuests(){
        return guests;
    }
}
