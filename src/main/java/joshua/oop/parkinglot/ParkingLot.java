package joshua.oop.parkinglot;

/**
 *
 * ParkingLot 代表停车场, 一个停车场有若干层(Level)。
 *
 * @author Joshua.Jiang on 2016/6/2.
 */
public class ParkingLot {

    private Level[] levels;

    private final int NUM_LEVELS = 5;

    public ParkingLot() {
        // 5 floors in total, for each floor we have 30 parking spot.
        levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++) {
            levels[i] = new Level(i, 30);
        }
    }

    /**
     * Park the vehicle in a spot (or multiple spots).
     * Return false if failed.
     */
    public boolean parkVehicle(Vehicle vehicle) {
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < levels.length; i++) {
            System.out.print("Level" + i + ": ");
            levels[i].print();
            System.out.println("");
        }
        System.out.println("");
    }
}
