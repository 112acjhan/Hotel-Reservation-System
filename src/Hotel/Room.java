package Hotel;

public abstract class Room {
    private String roomNumber;
    private String roomType;
    private double price;
    private String features;
    private String status;

    public Room(String roomNumber, String roomType, double price, String features, String status){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.features = features;
        this.status = status;
    }

    public boolean CheckAvailability(){
        return "Available".equalsIgnoreCase(status);
    }

    public void ReserveRoom(){
        if(CheckAvailability()){ this.status = "Reserved"; }
        else { System.out.println("Room not available for reservation"); }
    }

    public String GetRoomNumber() { return roomNumber; }
    public String GetRoomType(){ return roomType; }
    public double GetPrice() { return price; }
    public String GetFeatures() { return features; }
    public String GetStatus() { return status; }

    public void SetRoomNumber(String roomNumber){ this.roomNumber = roomNumber; }
    public void SetRoomType(String roomType){ this.roomType = roomType; }
    public void SetPrice(double price){ this.price = price; }
    public void SetFeatures(String features){ this.features = features; }
    public void SetStatus(String status){ this.roomNumber = status; }
}
