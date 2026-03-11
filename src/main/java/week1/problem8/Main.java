package week1.problem8;

public class Main {

    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot(10);

        lot.parkVehicle("ABC1234");
        lot.parkVehicle("ABC1235");
        lot.parkVehicle("XYZ9999");

        lot.exitVehicle("ABC1234");
    }
}