package ie.cit.hotelmanagement.service;

import ie.cit.hotelmanagement.model.Room;
import ie.cit.hotelmanagement.repository.RoomRepository;
import ie.cit.hotelmanagement.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RoomService {
    RoomRepository roomRepository;

    public RoomService(){
        roomRepository = RoomRepository.getInstance();
    }
    public ArrayList<Room> findAllRoom(){
        return roomRepository.findAllRoom();
    }
    public ArrayList<Room> findAvailableRoom(){
        ArrayList<Room> rooms = roomRepository.findAllRoom();
        ArrayList<Room> availableRoom = new ArrayList<>();
        for(Room room:rooms){
            if( room.getGuest() == null) {
                availableRoom.add(room);
            }
        }
        return availableRoom;
    }
    public Room findAvailableRoom(String roomType){
        ArrayList<Room> rooms = roomRepository.findAllRoom();
        for(Room room:rooms){
            if( room.getGuest() == null && room.getRoomType().equals(roomType)) {
                return room;
            }
        }
        return null;
    }

    public Room findRoomByNameAndPhone(String name, String phone){
        ArrayList<Room> rooms = roomRepository.findAllRoom();
        ArrayList<Room> availableRoom = new ArrayList<>();
        for(Room room:rooms){
            if( room.getGuest() != null
                    && room.getGuest().getName().equalsIgnoreCase(name)
                    && room.getGuest().getPhoneNumber().equalsIgnoreCase(phone)) {
                return room;
            }
        }
        return null;
    }
    public HashMap<String, Integer> getAvailableRoomsByType(){
       ArrayList<Room> rooms = this.findAvailableRoom();
       HashMap<String, Integer> availableRooms = new HashMap<>();
       for(Room room:rooms){
           if(availableRooms.containsKey(room.getRoomType())){
              int value = availableRooms.get(room.getRoomType());
              availableRooms.put(room.getRoomType(), value + 1);
           } else {
               availableRooms.put(room.getRoomType(), 1);
           }
       }
        return availableRooms;
    }
}
