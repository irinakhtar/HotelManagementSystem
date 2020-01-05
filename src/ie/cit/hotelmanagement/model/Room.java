package ie.cit.hotelmanagement.model;

public class Room {
    private int rate;
    private int capacity;
    private String roomType;
    private Guest guest;

    public Room(int rate, int capacity, String roomType, Guest guest) {
        this.rate = rate;
        this.capacity = capacity;
        this.roomType = roomType;
        this.guest = guest;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
