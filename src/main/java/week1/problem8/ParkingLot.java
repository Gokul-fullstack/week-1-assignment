package week1.problem8;

public class ParkingLot {

    private ParkingSpot[] table;
    private int size;

    public ParkingLot(int capacity) {
        table = new ParkingSpot[capacity];
        size = capacity;
    }

    private int hash(String plate) {
        return Math.abs(plate.hashCode()) % size;
    }

    public void parkVehicle(String plate) {

        int index = hash(plate);
        int probes = 0;

        while (table[index] != null) {
            index = (index + 1) % size;
            probes++;
        }

        table[index] = new ParkingSpot(plate);

        System.out.println("Vehicle " + plate +
                " parked at spot " + index +
                " (" + probes + " probes)");
    }

    public void exitVehicle(String plate) {

        int index = hash(plate);

        while (table[index] != null) {

            if (table[index].licensePlate.equals(plate)) {

                long duration =
                        (System.currentTimeMillis() -
                                table[index].entryTime) / 1000;

                table[index] = null;

                System.out.println(
                        "Vehicle " + plate +
                                " exited. Duration: " +
                                duration + " seconds"
                );

                return;
            }

            index = (index + 1) % size;
        }

        System.out.println("Vehicle not found");
    }
}