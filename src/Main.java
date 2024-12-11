import Database.MySQL_db;
import Hotel.*;

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

        /*try{
            db.prepareStatement("SELECT * FROM staff");
            db.ExecuteQuery();

            while(db.result.next()){
                System.out.println(db.result.getString("Name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }*/
    }
}