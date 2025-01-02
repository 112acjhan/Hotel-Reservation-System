import Database.MySQL_db;
import Hotel.*;
import Menu.*;

public class Main {
    public static void main(String[] args) {
        MySQL_db db = new MySQL_db();
        Hotel test = new Hotel("Test", "Durian Tunggal", 3);
        Room deluxeTest = new DeluxeRoom("D1001", 2500, "AC", "Available");
        test.AddRoom(deluxeTest);
        System.out.println(test.GetRating());

        for(Room rooms : test.GetAvailableRooms()){
            System.out.println(rooms.GetRoomNumber());
        }

        Main_Menu main_menu = new Main_Menu();
        main_menu.show();

    }
}