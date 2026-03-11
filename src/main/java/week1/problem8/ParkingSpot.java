package week1.problem8;

public class ParkingSpot {

    String licensePlate;
    long entryTime;

    public ParkingSpot(String licensePlate) {
        this.licensePlate = licensePlate;
        this.entryTime = System.currentTimeMillis();
    }
}