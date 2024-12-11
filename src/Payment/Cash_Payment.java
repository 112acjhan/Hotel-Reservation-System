package Payment;
import Database.MySQL_db;
import Hotel.*;

public class Cash_Payment implements Payment{
    private int payment_id;
    private Reservation reservation;
    private double amount;
    private String payment_method;

    public Cash_Payment(int payment_id, Reservation reservation, double amount) {
        this.payment_id = payment_id; this.reservation = reservation; this.amount = amount; this.payment_method = "Cash";
    }

    @Override
    public void ProcessPayment(){

    }

    @Override
    public void RefundPayment(){

    }
}
