package ie.cit.hotelmanagement.service;

import ie.cit.hotelmanagement.model.Room;
import ie.cit.hotelmanagement.repository.GuestRepository;
import ie.cit.hotelmanagement.repository.RoomRepository;
import ie.cit.hotelmanagement.utils.Utils;

import java.util.ArrayList;

public class PaymentService {

    public int getPriceForRoom(String roomType){
        if(roomType.equalsIgnoreCase(Utils.ROOM_TYPE.SINGLE.name())){
            return Utils.SINGLE_RENT;
        } else if(roomType.equalsIgnoreCase(Utils.ROOM_TYPE.DOUBLE.name())){
            return Utils.DOUBLE_RENT;
        } else if(roomType.equalsIgnoreCase(Utils.ROOM_TYPE.SUITE.name())) {
            return Utils.SUITE_RENT;
        }
        return 0;
    }
}
