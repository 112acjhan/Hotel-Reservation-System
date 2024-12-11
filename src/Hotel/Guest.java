package Hotel;

import java.sql.SQLException;
import java.util.Date;
import Database.MySQL_db;

public class Guest {
    private String name;
    private int IC;
    private String address;
    private String phoneNumber;
    private String email;

    public Guest(String name, int IC, String address, String phoneNumber, String email){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Reservation Book_Room(Room room, Date check_in_date, Date check_out_date){
        MySQL_db db = new MySQL_db();

        if (room.CheckAvailability()){
            int latestReservationId = -1;
            try {
                db.prepareStatement("SELECT COUNT(reservation_id) AS latest FROM reservation");
                db.QueryResult();
                db.result.next();
                latestReservationId = db.result.getInt("lastest");
            } catch (SQLException e){
                e.printStackTrace();
            }

            room.SetStatus("Reserved");
            return new Reservation(latestReservationId + 1,this, room, check_in_date, check_out_date);
        }else {
            System.out.println("Room is not available.");
        } return null;
    }

    public void Check_In(){

    }

    public void Check_Out(){

    }
}
