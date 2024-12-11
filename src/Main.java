import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        MySQL_db db = new MySQL_db();

        try{
            db.prepareStatement("SELECT * FROM staff");
            db.ExecuteQuery();

            while(db.result.next()){
                System.out.println(db.result.getString("Name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}