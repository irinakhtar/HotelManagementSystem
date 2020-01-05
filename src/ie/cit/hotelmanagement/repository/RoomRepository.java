package ie.cit.hotelmanagement.repository;

import ie.cit.hotelmanagement.model.Room;
import ie.cit.hotelmanagement.utils.Utils;

import java.util.ArrayList;

public class RoomRepository {

    private static RoomRepository roomRepository;
    private ArrayList<Room> rooms;

    private RoomRepository(){
        rooms = new ArrayList<>(Utils.TOTAL_MAX_ROOM);
        addAllRoom();
    }
    public static RoomRepository getInstance(){
        if(roomRepository == null){
            roomRepository = new RoomRepository();
        }
        return roomRepository;
    }
    public void addAllRoom(){
        for(int i = 0; i < Utils.SINGLE_ROOM_COUNT; i++) {
            rooms.add(new Room(Utils.SINGLE_RENT, Utils.SINGLE_PERSONS, Utils.ROOM_TYPE.SINGLE.name(), null));
        }
        for(int i = 0; i < Utils.DOUBLE_ROOM_COUNT; i++) {
            rooms.add(new Room(Utils.DOUBLE_RENT, Utils.DOUBLE_PERSONS, Utils.ROOM_TYPE.DOUBLE.name(), null));
        }
        for(int i = 0; i < Utils.SUITE_ROOM_COUNT; i++) {
            rooms.add(new Room(Utils.SUITE_RENT, Utils.SUITE_PERSONS, Utils.ROOM_TYPE.SUITE.name(), null));
        }
    }
    public ArrayList<Room> findAllRoom(){
        return rooms;
    }
}
