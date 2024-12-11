package Hotel;
import Database.MySQL_db;
import java.util.Date;

public class Reservation {
    private int reservation_id;
    private Guest guest;
    private Room room;
    private Date check_in_date;
    private Date check_out_date;

    public Reservation(int reservation_id, Guest guest, Room room, Date check_in_date, Date check_out_date){
        this.reservation_id = reservation_id;
        this.guest = guest;
        this.room = room;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
    }

    public void Make_Reservation(){

    }

    public void Cancel_Reservation(){

    }

    public void Modify_Reservation(Date new_check_in_date, Date new_check_out_date){

    }

}
