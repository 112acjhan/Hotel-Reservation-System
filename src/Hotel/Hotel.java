package Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final String name;
    private final String address;
    private final int rating;
    private final List<Room> rooms;

    public Hotel(String name, String address, int rating){
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.rooms = new ArrayList<>();
    }

    public void AddRoom(Room room){
        rooms.add(room);
    }

    public List<Room> GetAvailableRooms(){
        List<Room> availableRooms = new ArrayList<>();
        for(Room room : rooms){
            if(room.CheckAvailability()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public String GetName(){ return name; }

    public String GetAddress(){ return address; }

    public int GetRating(){ return rating; }
}
