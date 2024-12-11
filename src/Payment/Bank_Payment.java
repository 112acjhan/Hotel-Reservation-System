package Payment;
import Database.MySQL_db;
import Hotel.*;

public class Bank_Payment implements Payment{
    private int payment_id;
    private Reservation reservation;
    private double amount;
    private String payment_method;

    // Can be "Bank Transfer" or "Credit Card"
    public Bank_Payment(int payment_id, Reservation reservation, double amount, String payment_method){
        this.payment_id = payment_id;
        this.reservation = reservation;
        this.amount = amount;
        this.payment_method = payment_method;
    }


    @Override
    public void ProcessPayment(){

    }

    @Override
    public void RefundPayment(){

    }
}
