package ie.cit.hotelmanagement;

import ie.cit.hotelmanagement.model.Guest;
import ie.cit.hotelmanagement.model.Room;
import ie.cit.hotelmanagement.service.GuestService;
import ie.cit.hotelmanagement.service.ReservationService;
import ie.cit.hotelmanagement.service.RoomService;

import java.util.*;

public class Main {
    public static final int DISPLAY_AVAILABLE = 1;
    public static final int DISPLAY_GUEST = 2;
    public static final int RESERVATION = 3;
    public static final int PAYMENT = 4;
    public static final int EXIT = 5;

    public static final int NEW_RESERVATION = 1;
    public static final int VIEW_RESERVATION = 2;
    public static final int CANCEL_RESERVATION = 3;
    public static final int RETURN = 4;
    
    public static Scanner input = new Scanner(System.in);
    
    public static RoomService roomService = new RoomService();
    public static GuestService guestService = new GuestService();
    public static ReservationService reservationService = new ReservationService();

    public static void main(String[] args) {
	    int option;
        do {
            printMainMenu();
            option = input.nextInt();
            execute(option);
        } while (option!=EXIT);
    }

    private static void execute(int option) {
        switch (option){
            case DISPLAY_AVAILABLE:
                displayAvailableRooms();
                break;
            case DISPLAY_GUEST:
                displayGuest();
                break;
            case RESERVATION:
                displayReservationMenu();
                break;
            case PAYMENT:
                System.out.println("Payment received.");
                break;
        }
    }

    private static void displayGuest() {
        GuestService guestService = new GuestService();
        ArrayList<Guest> guests = guestService.findAllGuest();
        for(Guest guest:guests){
            System.out.println(guest.getName() + " " + guest.getAddress() + " "+ guest.getEmail());
        }
    }

    private static void displayAvailableRooms() {
       HashMap<String, Integer> availableRooms = roomService.getAvailableRoomsByType();
        Iterator iterator = availableRooms.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry pairs = (Map.Entry)iterator.next();
            System.out.println(pairs.toString());
        }
    }

    public static void printMainMenu(){
        System.out.println("Welcome to CIT Hotel Management System");
        System.out.println("************************************");
        System.out.println("1) Display Available Rooms\n"
                + "2) Display Guests\n"
                + "3) Process Reservation\n"
                + "4) Process Payment\n"
                + "5) Exit\n");
    }
    public static void displayReservationMenu() {
        int option;
        do {
            System.out.println("Welcome to Reservations");
            System.out.println("************************************");
            System.out.println("1) New Reservation\n"
                    + "2) View Reservation\n"
                    + "3) Cancel Reservation\n" +
                    "4) Return\n");
            option = input.nextInt();
            executeReservation(option);
        } while (option != RETURN);
    }

    private static void executeReservation(int option) {
        switch (option){
            case NEW_RESERVATION:
                System.out.print("Name= ");
                String name = input.next();
                System.out.print("Email= ");
                String email = input.next();
                System.out.print("Address= ");
                String address = input.next();
                System.out.print("Phone= ");
                String phone = input.next();
                System.out.print("SNN= ");
                String SSN = input.next();
                System.out.print("Room Type=");
                String roomType = input.next();
                Guest guest = new Guest(name,email,address,phone,SSN);
                guestService.addGuest(guest);
                Room room = roomService.findAvailableRoom(roomType);
                if(room != null){
                    reservationService.addReservation(guest,room);
                    System.out.println("Room reservation okay");
                } else {
                    System.out.println("Room is not Available");
                }
                break;
            case VIEW_RESERVATION:
                System.out.print("Name= ");
                name = input.next();
                System.out.print("Phone= ");
                phone = input.next();
                Guest guestItem = reservationService.viewReservation(name, phone);
                if(guestItem != null){
                    System.out.println(guestItem.getName() + " " + guestItem.getPhoneNumber() + " "
                            + guestItem.getAddress() + " " + guestItem.getEmail() + " "+ guestItem.getSSN());
                }
                break;
            case CANCEL_RESERVATION:
                System.out.print("Name= ");
                name = input.next();
                System.out.print("Phone= ");
                phone = input.next();
                room = roomService.findRoomByNameAndPhone(name, phone);
                reservationService.cancelReservation(room);
                System.out.println("Reservation canceled");
                break;
        }
    }
}
